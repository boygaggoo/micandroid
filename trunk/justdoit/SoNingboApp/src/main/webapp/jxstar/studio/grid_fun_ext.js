﻿Jxstar.currentPage = function() {
	var config = {param:{},initpage:function(page, define){},eventcfg:{}};

	var cols = [
	{col:{header:'Grid扩展文件', width:327, sortable:true, editable:true, hcss:'color:#3039b4;',
		editor:new Ext.form.TextField({
			maxLength:100
		})}, field:{name:'fun_ext__grid_initpage',type:'string'}},
	{col:{header:'Form扩展文件', width:329, sortable:true, editable:true, hcss:'color:#3039b4;',
		editor:new Ext.form.TextField({
			maxLength:100
		})}, field:{name:'fun_ext__form_initpage',type:'string'}},
	{col:{header:'扩展ID', width:100, sortable:true, hidden:true}, field:{name:'fun_ext__ext_id',type:'string'}},
	{col:{header:'功能ID', width:100, sortable:true, hidden:true}, field:{name:'fun_ext__fun_id',type:'string'}}
	];
	
	config.param = {
		cols: cols,
		sorts: null,
		hasQuery: '0',
		isedit: '1',
		isshow: '0',
		funid: 'fun_ext'
	};
	
	config.eventcfg = {
		createjs: function(){
			var params = 'funid=fun_text&pagetype=editgrid&eventcode=createjs&projectpath=' + 

			//生成文件后自动加载该文件
			var hdcall = function() {
				Request.loadJS('/public/locale/jxstar-lang-zh.js');
			};

			//发送请求
			Request.postRequest(params, hdcall);
		}
	};
		
	return new Jxstar.GridNode(config);
}