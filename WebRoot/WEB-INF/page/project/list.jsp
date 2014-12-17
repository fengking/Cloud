<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/inc.jsp"></jsp:include>
   <style>
   .input{
     width: 170px;
   }
   </style>
<script type="text/javascript">
var project_list_datagrid;
	$(function() {
		project_list_datagrid = $('#project_list_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/projectlistAction.html',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'sprojcode',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'sprojcode',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				title : '项目编号',
				field : 'sprojcode',
				width : 50,
				checkbox : true
			}, {
				field : 'sprojname',
				title : '项目英文名称',
				width : 70
			},{
				field : 'sprojchename',
				title : '项目中文名称',
				width : 120
			},{
				field : 'sdesc',
				title : '项目描述',
				width : 120
			} ] ],
			columns : [ [ {
				field : 'sdbtype',
				title : '数据库类型',
				width : 50
			},{
				field : 'sdbschema',
				title : '数据库SCHEMA',
				width : 50
			}, {
				field : 'sdbname',
				title : '数据库用户名',
				width : 50
			}, {
				field : 'sdbpwd',
				title : '数据库密码',
				width : 50,
				hidden : true
			}, {
				field : 'sdburl',
				title : '数据库地址',
				width : 80
			},{
				field : 'susercode',
				title : '添加人',
				width : 80
			},{
				field : 'tsadddate',
				title : '添加时间',
				width : 80
			}, {
				field : 'action',
				title : '动作',
				width : 50,
				formatter : function(value, row, index) {
					return formatString('<img onclick="project_list_editFun(\'{0}\');" src="{1}"/>&nbsp;<img onclick="project_list_deleteFun(\'{2}\');" src="{3}"/>', row.sprojcode, '${pageContext.request.contextPath}/js/icons/pencil.png', row.sprojcode, '${pageContext.request.contextPath}/js/icons/cancel.png');
				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					project_list_addFun();
				}
			} ,'-', {
				text : '批量删除',
				iconCls : 'icon-cancel',
				handler : function() {
					project_list_removeFun();
				}
			} ,'-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					project_list_datagrid.datagrid('reload');
				}
			},'-']
		});
	});
	
/**
 * 增加项目
 */
	function project_list_addFun() {
	
	    project_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/project_add.html',
			width : 700,
			height : 420,
			modal : true,
			title : '项目添加',
			buttons : [ {
			  text:'测试连接',
			  handler:function(){
			   $('#project_add_addForm').form('submit', {
						url : '${pageContext.request.contextPath}/dbtestConnAction.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								$.messager.alert('提示', r.msg);
							} catch (e) {
								$.messager.alert('提示', result);
							}
						}
					});
			  }
			},{
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#project_add_addForm').form('submit', {
						url : '${pageContext.request.contextPath}/addprojectAction.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									project_list_datagrid.datagrid('insertRow', {
										index : 0,
										row : r.obj
									});
									d.dialog('destroy');
									//使用ajax在添加过项目后自动解析数据库表
									$.ajax({
	     	 							url:'${pageContext.request.contextPath}/structsDbAction.html',
	     								data: 'project.sprojcode=' + r.obj.sprojcode,
	    	 							timeout : 1000 * 60 * 20, //超时时间20分钟
	    	 							success:function(result){
	         	 						var rs = $.parseJSON(result);
			 							 if (rs.success) {
			 	    						$.messager.show({title : '提示', msg : rs.msg});
			  							}else{
			  	    						$.messager.show({title : '错误', msg : rs.msg});
			  							}
	    	 						},
	     	 						error:function(result){
	       								 var rs = $.parseJSON(result);
	       	    						 $.messager.alter('错误', rs);
	    	 						}
								});
								}
								$.messager.show({title : '提示', msg : r.msg});
							} catch (e) {
								$.messager.alert('提示', result);
							}
						}
					});
				}
			}],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 *删除选中行
	 *
	 */
	function project_list_removeFun() {
		var rows = project_list_datagrid.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目?', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].sprojcode);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/delprojectAction.html',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								project_list_datagrid.datagrid('load');
								project_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							}
							$.messager.show({
									title : '提示',
									msg : result.msg
							});
						},
						error : function(result){
							$.messager.alert('错误', result);
						}
					});
				}
			});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选要删除的记录！'
			});
		}
	}
	
	/**
	 *删除当前行
	 */
	function project_list_deleteFun(id) {
		project_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		project_list_datagrid.datagrid('checkRow', project_list_datagrid.datagrid('getRowIndex', id));
		project_list_removeFun();
	}
	
	/**
	*修改项目
	*/
	function project_list_editFun(id) {
/*
		if (id != undefined) {
			project_list_datagrid.datagrid('selectRow', id);
		}
		var rows = project_list_datagrid.datagrid('getChecked');
		console.info(rows);
		if(rows.length > 0){
		  $.messager.show({title : '提示',msg : '请选中一条记录进行修改!'});
		  */
		  project_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		/*
		  return;
		}
		*/
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/project_edit.html',
			width : 700,
			height : 420,
			modal : true,
			title : '项目修改',
			buttons : [ {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#project_edit_editForm').form('submit', {
						url : '${pageContext.request.contextPath}/editprojectAction.html',
						
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									project_list_datagrid.datagrid('updateRow', {
										index : project_list_datagrid.datagrid('getRowIndex', id),
										row : r.obj
									});
									d.dialog('destroy');
								}
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
							} catch (e) {
								$.messager.alert('提示', result);
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				var index = project_list_datagrid.datagrid('getRowIndex', id);
				var rows = project_list_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#project_edit_editForm').form('load', o);
			}
		});
	}
	
	/**
	 *项目查询
	 */
	function project_list_searchFun(){
	 project_list_datagrid.datagrid('load', serializeObject($('#project_list_searchForm')));
	}
	
	/**
	*清空
	*/
	function project_list_cleanFun(){
	  $('#project_list_searchForm input').val('');
	  project_list_datagrid.datagrid('load', {});
	}
</script>
<div class="easyui-layout" data-options="fit : true,border : false">
<div data-options="region:'north',title:'查询条件',border:false" style="height: 185px;overflow: hidden;" align="center">
  	<form id="project_list_searchForm">
			<table class="tableForm">
				<tr>
					<th style="width: 170px;">项目英文名称</th>
					<td><input name="sprojname"/></td>
					<th style="width:170px;">项目中文名称</th>
					<td><input name="sprojchename"/></td>
				</tr>
				<tr>
					<th>创建人</th>
					<td><input name="susercode"/></td>
					<th>数据库类型</th>
					<td><input name="sdbtype"/></td>
				</tr>
				<tr>
					<th>添加日期</th>
					<td colspan="2"><input name="startDate" class="easyui-datebox"  data-options="editable:false"/>至<input name="endDate" class="easyui-datebox"  data-options="editable:false"/></td>
				</tr>
			</table>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="project_list_searchFun();">查询</a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="project_list_cleanFun();">清空查询条件</a>
		</form>
</div>
<div data-options="region:'center',border:false">
   <table id="project_list_datagrid"></table>
</div>
</div>