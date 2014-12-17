<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/inc.jsp"></jsp:include>
   <style>
   .input{
     width: 170px;
   }
   </style>
<script type="text/javascript">
var table_list_datagrid;
	$(function() {
		table_list_datagrid = $('#table_list_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/listTableAction.html',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : false,
			idField : 'itableid',
			sortName : 'itableid',
			sortOrder : 'asc',
			striped : true,
			rownumbers : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				title : '',
				field : 'itableid',
				width : 80,
				checkbox : true
			},{
				title : '表英文名',
				field : 'stabname',
				width : 150,
			},{
				field : 'stabcname',
				title : '表中文名',
				width : 240
			}, {
				field : 'action',
				title : '动作',
				width : 80,
				formatter : function(value, row, index) {
				    return "";
					//return formatString('<img onclick="project_list_editFun(\'{0}\');" src="{1}"/>&nbsp;<img onclick="project_list_deleteFun(\'{2}\');" src="{3}"/>', row.sprojcode, '${pageContext.request.contextPath}/js/icons/pencil.png', row.sprojcode, '${pageContext.request.contextPath}/js/icons/cancel.png');
				}
			} ] ],
			toolbar : [ {
				text : '生成Hibernate POJO对象',
				iconCls : 'icon-save',
				handler : function() {
					table_gen_hibernate_pojo();
				}
			} ,'-', {
				text : '生成IBatis对象',
				iconCls : 'icon-save',
				handler : function() {
					table_gen_ibatis();
				}
			} ,'-',{
				text : '更新数据库结构',
				iconCls : 'icon-ok',
				handler : function() {
					update_table_desc();
				}
			} ,'-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					table_list_datagrid.datagrid('reload');
				}
			},'-']
		});
	});
	
	/**
	 * 全选
	 */
	function table_list_selectAllFun() {
	   table_list_datagrid.datagrid('selectAll').datagrid('checkAll');
	}
	/**
	*反选
	*/
	function table_list_unselectAllFun(){
	   table_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
	}
	
	/**
	 *更新数据库结构
	 */
	function update_table_desc(){
	var projectcode = $('#table_search_projectcode').combogrid('getValue');
	   if(projectcode == null || projectcode == ''){
	     $.messager.alert('提示','请选择要更新的项目!');
	     return;
	   }
	   $.messager.confirm('提示','确认要更新数据库结构么?(如果表比较多,可能需要很长时间)',function(r){
	    if(r){
	   	$.messager.progress({text : '正在更新数据库结构,请稍等....',interval : 100});
	       $.ajax({
	     	 url:'${pageContext.request.contextPath}/structsDbAction.html',
	     	 data: 'project.sprojcode=' + projectcode,
	    	 timeout : 1000 * 60 * 20,
	    	 success:function(result){
	         	 var rs = $.parseJSON(result);
			 	 if (rs.success) {
			 	    $.messager.progress('close');
			 	    $.messager.show({title : '提示', msg : rs.msg});
			  	}else{
			  	    $.messager.show({title : '错误', msg : rs.msg});
			  	}
			  	table_list_datagrid.datagrid('load', serializeObject($('#table_list_searchForm')));
	    	 },
	     	 error:function(result){
	     	    $.messager.progress({text : '页面加载中....',interval : 100});
	       		var rs = $.parseJSON(result);
	       	    $.messager.alter('错误', rs);
	    	 }
	   });
	    }
	   });
	   
	}
	/**
	 *项目查询
	 */
	function project_list_searchFun(){
	 table_list_datagrid.datagrid('load', serializeObject($('#table_list_searchForm')));
	}
	
	/**
	*清空
	*/
	function project_list_cleanFun(){
	  $('#tabname').val('');
	  $('#tabcname').val('');
	  table_list_datagrid.datagrid('load', serializeObject($('#table_list_searchForm')));
	}
</script>
<div class="easyui-layout" data-options="fit : true,border : false">
<div data-options="region:'north',title:'查询条件',border:false" style="height: 105px;overflow: hidden;" align="center">
  	<form id="table_list_searchForm">
			<table class="tableForm">
				<tr>
					<th style="width: 100px;">项目选择</th>
					<td><select id="table_search_projectcode" class="easyui-combogrid" name="project.sprojcode" style="width:150px;" data-options="required:true, panelWidth:340,idField:'sprojcode',textField:'sprojname',url:'${pageContext.request.contextPath}/projectComboAction.html',columns:[[
                {field:'sprojname',title:'项目名称',width:70},
                {field:'sprojchename',title:'项目中文名称',width:100},
                {field:'sdbtype',title:'数据类型',width:50},
                {field:'sdbname',title:'用户名',width:70},
                {field:'sdbpwd',title:'密码',width:70},
                {field:'sdburl',title:'JDBC URL',width:120},
                {field:'sdbschema',title:'SCHEMA',width:120}
                ]]"></select>&nbsp;</td>
					<th style="width:100px;">表英文名</th>
					<td><input id="tabname" name="table.stabname"/></td>
					<th style="width:100px;">表中文名</th>
					<td><input id="tabcname" name="table.stabcname"/></td>
				</tr>
			</table>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="project_list_searchFun();">查询</a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="project_list_cleanFun();">清空查询条件</a>
		</form>
</div>
<div data-options="region:'center',border:false">
   <table id="table_list_datagrid"></table>
</div>
</div>