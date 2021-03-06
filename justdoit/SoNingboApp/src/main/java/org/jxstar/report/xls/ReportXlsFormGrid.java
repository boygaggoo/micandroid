/*
 * ReportXlsFormGrid.java 2010-11-11
 * 
 * Copyright 2008-2011 the original author or authors.
 * Licensed under the Apache License, Version 2.0
 */
package org.jxstar.report.xls;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.jxstar.dao.DaoParam;
import org.jxstar.report.ReportException;
import org.jxstar.report.util.ReportXlsUtil;
import org.jxstar.util.StringUtil;
import org.jxstar.util.factory.FactoryUtil;

/**
 * 输出主从报表。
 *
 * @author TonyTan
 * @version 1.0, 2010-11-11
 */
public class ReportXlsFormGrid extends ReportXls {

	/**
	 * 输出报表内容
	 */
	public Object output() throws ReportException {
		_log.showDebug("excel form-grid report output ...");
		//取报表所属功能ID，用于报表图片输出时取功能表名、主键信息用
		String funId = _mpReptInfo.get("fun_id");
		//每输出一页构建一个临时报表对象
		HSSFWorkbook tmpwb = ReportXlsUtil.readWorkBook(_xlsFile);
		HSSFSheet tmpsheet = tmpwb.getSheetAt(0);

		HSSFSheet sheet = _hssfWB.getSheetAt(0);

		Map<String, String> mpValue = null;
		for (int i = 0; i < _lsMainRecord.size(); i++) {
			mpValue = _lsMainRecord.get(i);
			
			//填写一条记录
			if (i == 0) {
				sheet = ReportXlsUtil.fillForm(funId, sheet, mpValue, _lsMainCol, i + 1, _lsMainRecord.size());
				sheet = ReportXlsUtil.fillHead(sheet, _lsHeadInfo);

				//填写从表信息
				sheet = fillSubArea(sheet, mpValue);
			} else {
				tmpsheet = ReportXlsUtil.fillForm(funId, tmpsheet, mpValue, _lsMainCol, i + 1, _lsMainRecord.size());
				tmpsheet = ReportXlsUtil.fillHead(tmpsheet, _lsHeadInfo);

				//填写明细数据，如果明细数据有多页，则多页数据都生成合并到tmpsheet中，最后再合并到原表中。
				tmpsheet = fillSubArea(tmpsheet, mpValue);
				sheet = ReportXlsUtil.appendSheet(sheet, tmpsheet);
				tmpwb = ReportXlsUtil.readWorkBook(_xlsFile);
				tmpsheet = tmpwb.getSheetAt(0);
			}

			//判断报表是否允许输出
			if (!ReportXlsUtil.isAllowOut(sheet)) break;
		}

		return _hssfWB;
	}

	/**
	 * 填写子表内容，返回的子表内容报表可能存在多页。
	 * 
	 * @param sheet -- 表格对象
	 * @param mpData -- 主表记录值
	 * @return
	 * @throws ReportException
	 */
	private HSSFSheet fillSubArea(HSSFSheet sheet, Map<String, String> mpData) throws ReportException {
		String strPKCol = _mpMainArea.get("pk_col");
		String strTblName = _mpMainArea.get("main_table");

		//判断主表名是否为空
		if (strTblName == null || strTblName.length() == 0)
			throw new ReportException("报表区域中的主表名不能为空！");

		//判断主键名是否为空
		if (strPKCol == null || strPKCol.length() == 0)
			throw new ReportException("报表区域中的主键名不能为空！");
		
		//取主键字段名
		strPKCol = StringUtil.getNoTableCol(strPKCol);
		
		//String user_id = _mpUser.get("user_id");
		String pkval = mpData.get(strPKCol.toLowerCase());
		Map<String, List<Map<String,String>>> mpSubRecord = 
			//getSubRecord(pkval, strPKCol, _lsSubArea, user_id, _pageSql, _pageSqlValue, _pageSqlType);
			getSubRecord(pkval, strPKCol, _lsSubArea);
		int maxPage = getMaxPageBySubRecord(mpSubRecord, _lsSubArea);

		Map<String,String> mpField = null;
		List<Map<String,String>> lsRecord = null, lsCollist = null;
		String strAreaID = null, strPageNum = null, isStatArea = null;

		//取报表所属功能ID，用于报表图片输出时取功能表名、主键信息用
		String funId = _mpReptInfo.get("fun_id");
		
		//每输出一页构建一个临时报表对象
		HSSFWorkbook tmpwb = ReportXlsUtil.readWorkBook(_xlsFile);
		HSSFSheet tmpsheet = tmpwb.getSheetAt(0);

		//输出每个明细表的数据到表格中，每输满一页后添加到源表单中
		int curNum = 0;
		for (int i = 0; i < maxPage; i++) {
			//区域
			for (int j = 0, n = _lsSubArea.size(); j < n; j++) {
				mpField = _lsSubArea.get(j);
				strAreaID = mpField.get("area_id");
				strPageNum = mpField.get("page_size");
				isStatArea = mpField.get("is_stat");
				if (isStatArea == null) isStatArea = "";

				//当前显示数
				curNum = i * Integer.parseInt(strPageNum);

				lsCollist = _mpSubCol.get(strAreaID);
				lsRecord = mpSubRecord.get(strAreaID);
				
				if (isStatArea.equals("1")) {
					curNum = 0;
				}

				//i=0时的明细内容填充到sheet中，后面每页的内容填充到tmpsheet
				if (i > 0) {
					tmpsheet = ReportXlsUtil.fillGrid(tmpsheet, lsRecord, lsCollist, Integer.parseInt(strPageNum), curNum, i + 1, maxPage);

					if ((j + 1) == n) {
						if (!ReportXlsUtil.isAllowOut(sheet)) break;
						sheet = ReportXlsUtil.appendSheet(sheet, tmpsheet);
					} 
				} else {
					sheet = ReportXlsUtil.fillGrid(sheet, lsRecord, lsCollist, Integer.parseInt(strPageNum), curNum, i + 1, maxPage);
				}
			}

			//如果小于maxPage
			if ((i + 1) < maxPage) {
				//向新的form填写
				tmpwb = ReportXlsUtil.readWorkBook(_xlsFile);
				tmpsheet = tmpwb.getSheetAt(0);
				tmpsheet = ReportXlsUtil.fillForm(funId, tmpsheet, mpData, _lsMainCol, i + 1, maxPage);
			}
		}

		return sheet;
	}

	/**
	 * 返回明细记录的页数，以页数最多的哪个明细为准。
	 * 
	 * @param mpSubRecord -- 明细表数据
	 * @param lsSubArea -- 明细区域定义信息
	 * @return
	 * @throws ReportException
	 */
	private static int getMaxPageBySubRecord(
			Map<String, List<Map<String,String>>> mpSubRecord, 
			List<Map<String,String>> lsSubArea) throws ReportException {
		int ret = 0;

		for (int i = 0, n = lsSubArea.size();i < n; i++) {
			Map<String,String> mpValue = lsSubArea.get(i);
			String rowNum = mpValue.get("page_size");
			String areaName = mpValue.get("area_name");
			if (rowNum == null || rowNum.length() == 0)
				throw new ReportException("[" + areaName + "]区域中定义的每页明细记录数无效！");

			List<Map<String,String>>  lsData = mpSubRecord.get(mpValue.get("area_id"));
			int itmp = lsData.size() / Integer.parseInt(rowNum);
			int ipage = (lsData.size()%Integer.parseInt(rowNum) == 0)?itmp:itmp + 1;

			if (ret < ipage) ret = ipage;
		}
		
		return ret;
	}

	/**
	 * 查询明细表数据
	 * @param keyID -- 主表记录值
	 * @param pkcol -- 主键名
	 * @param lsSubArea -- 明细区域定义信息
	 * @return
	 * @throws ReportException
	 */
	private static Map<String, List<Map<String,String>>> getSubRecord(String keyID, 
									String pkcol, 
									List<Map<String,String>> lsSubArea) throws ReportException {
		Map<String, List<Map<String,String>>> ret = FactoryUtil.newMap();

		if (lsSubArea.isEmpty()) return ret;

		for (int i = 0, n = lsSubArea.size(); i < n; i++) {
			Map<String,String> mpField = lsSubArea.get(i);
		
			String sql = mpField.get("data_sql");
			String areaName = mpField.get("area_name");
			String tableName = mpField.get("main_table");
			//String funid = mpField.get("fun_id");
			String subFkcol = mpField.get("sub_fkcol");
			//String isUseWhere = mpField.get("is_use_where");
			//String dataWhere = "";
			
			if (subFkcol == null || subFkcol.length() == 0) {
				subFkcol = pkcol;
			} else {
				subFkcol = StringUtil.getNoTableCol(subFkcol);
			}
			
			//if (isUseWhere == null) isUseWhere = "";
			/*if (funid == null) funid = "";
			if (funid.length() > 0) {
				dataWhere = SysDataUtil.getDataWhere(userid, funid);
			}*/
		
			String strWhere = mpField.get("data_where");
			String strOrder = mpField.get("data_order");
			String strGroup = mpField.get("data_group");
		
			String dsName = mpField.get("ds_name");

			sql += " where (" + tableName + "." + subFkcol + " = '"+keyID+"')";
			/*if (isUseWhere.equals("1")) {
				if (orgWhereSQL.length() > 0) 
					sql += " and (" + orgWhereSQL + ")";
			}*/
			if(strWhere.length() > 0) {
				sql += " and (" + strWhere + ")";
			}
			//if (dataWhere.length() > 0) sql += " and ("+dataWhere+")";
		
			if (strGroup.length() > 0) {
				sql += " group by " + strGroup;
			}
		
			if (strOrder.length() > 0) {
				sql += " order by " + strOrder;
			}
			_log.showDebug(areaName + "[" + keyID + "] " + "sub sql = " + sql);
		
			DaoParam param = _dao.createParam(sql);
			param.setDsName(dsName);
			
			/*if (isUseWhere.equals("1")) {
				if (orgWhereValue.length() > 0) {
					param.setType(orgWhereType);
					param.setValue(orgWhereValue);
				}
			}*/
			List<Map<String,String>> lsTmpRs = _dao.query(param);
		
			_log.showDebug(areaName + "[" + keyID + "] " + "data size = " + lsTmpRs.size());
			ret.put(mpField.get("area_id"), lsTmpRs);
		}

		return ret;
	}

}
