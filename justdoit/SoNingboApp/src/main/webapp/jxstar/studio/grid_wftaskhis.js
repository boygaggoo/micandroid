﻿Jxstar.currentPage = function() {
	var config = {param:{},initpage:function(page, define){},eventcfg:{}};

	var yesnoData = Jxstar.findComboData('yesno');

	var cols = [
	{col:{header:'处理人', width:67, sortable:true}, field:{name:'wf_taskhis__check_user',type:'string'}},
	{col:{header:'处理时间', width:113, sortable:true, renderer:function(value) {
			return value ? value.format('Y-m-d H:i') : '';
		}}, field:{name:'wf_taskhis__check_date',type:'date'}},
	{col:{header:'处理意见', width:195, sortable:true}, field:{name:'wf_taskhis__check_desc',type:'string'}},
	{col:{header:'开始时间', width:112, sortable:true, renderer:function(value) {
			return value ? value.format('Y-m-d H:i') : '';
		}}, field:{name:'wf_taskhis__start_date',type:'date'}},
	{col:{header:'受限时间', width:109, sortable:true, renderer:function(value) {
			return value ? value.format('Y-m-d H:i') : '';
		}}, field:{name:'wf_taskhis__limit_date',type:'date'}},
	{col:{header:'超时?', width:52, sortable:true, align:'center',
		editable:true,
		editor:new Ext.form.ComboBox({
			store: new Ext.data.SimpleStore({
				fields:['value','text'],
				data: yesnoData
			}),
			emptyText: jx.star.select,
			mode: 'local',
			triggerAction: 'all',
			valueField: 'value',
			displayField: 'text',
			editable:false,
			value: yesnoData[0][0]
		}),
		renderer:function(value){
			for (var i = 0; i < yesnoData.length; i++) {
				if (yesnoData[i][0] == value)
					return yesnoData[i][1];
			}
		}}, field:{name:'wf_taskhis__is_timeout',type:'string'}},
	{col:{header:'发邮件?', width:62, sortable:true, align:'center',
		editable:true,
		editor:new Ext.form.ComboBox({
			store: new Ext.data.SimpleStore({
				fields:['value','text'],
				data: yesnoData
			}),
			emptyText: jx.star.select,
			mode: 'local',
			triggerAction: 'all',
			valueField: 'value',
			displayField: 'text',
			editable:false,
			value: yesnoData[0][0]
		}),
		renderer:function(value){
			for (var i = 0; i < yesnoData.length; i++) {
				if (yesnoData[i][0] == value)
					return yesnoData[i][1];
			}
		}}, field:{name:'wf_taskhis__has_email',type:'string'}},
	{col:{header:'功能ID', width:100, sortable:true, hidden:true}, field:{name:'wf_taskhis__fun_id',type:'string'}},
	{col:{header:'任务ID', width:100, sortable:true, hidden:true}, field:{name:'wf_taskhis__task_id',type:'string'}},
	{col:{header:'数据ID', width:100, sortable:true, hidden:true}, field:{name:'wf_taskhis__data_id',type:'string'}},
	{col:{header:'处理类型', width:100, sortable:true, hidden:true}, field:{name:'wf_taskhis__check_type',type:'string'}}
	];
	
	config.param = {
		cols: cols,
		sorts: null,
		hasQuery: '0',
		isedit: '0',
		isshow: '1',
		funid: 'wf_taskhis'
	};
	
	
		
	return new Jxstar.GridNode(config);
}