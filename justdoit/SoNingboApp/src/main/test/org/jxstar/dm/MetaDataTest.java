/*
 * MetaDataTest.java 2010-12-23
 * 
 * Copyright 2008-2011 the original author or authors.
 * Licensed under the Apache License, Version 2.0
 */
package org.jxstar.dm;

import java.util.Map;


import org.jxstar.dao.BaseDao;
import org.jxstar.dao.DaoParam;
import org.jxstar.dm.studio.ReverseBO;
import org.jxstar.test.AbstractTest;

/**
 * 读取数据库元数据的测试类。
 *
 * @author TonyTan
 * @version 1.0, 2010-12-23
 */
public class MetaDataTest extends AbstractTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		//MetaDataTest.queryDefault();
		
		MetaDataTest.reverse();
	}
	
	public static void reverse() {
		ReverseBO reverse = new ReverseBO();
		
		String[] tableNames = new String[]{"fun_base", "fun_col"};
		String userid = "administrator";
		reverse.reverse(tableNames, userid);
	}
	
	public static void queryDefault() {
		BaseDao _dao = BaseDao.getInstance();
		
		String sql = "select table_name, column_name, default_length, data_default " +
					 "from user_tab_cols where table_name = 'FUN_COL' and column_name = 'IS_UPDATE'";
		
		DaoParam param = _dao.createParam(sql);
		Map<String, String> mp = _dao.queryMap(param);
		System.out.println("================" + mp.toString());
	}

}
