<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <jsp:include page="/inc.jsp"></jsp:include>
   <style>
   .input{
     width: 170px;
   }
   </style>
<script type="text/javascript">
    var dbquery_list_datagrid = null;
	$(function() {
		dbquery_list_datagrid = $('#dbquery_list_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/dbqueryAction.html',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'sdbtype',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'sdbtype',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : true,
			nowrap : false,
			frozenColumns : [ [ {
				field : 'sdbtype',
				title : '数据库类型',
				width : 50
			}] ],
			columns : [ [{
				field : 'squerytabinfo',
				title : '查询表信息',
				width : 100
			}, {
				field : 'squerycolumn',
				title : '查询列信息',
				width : 100
			}, {
				field : 'squerypk',
				title : '查询主键',
				width : 100
			}, {
				field : 'sjdbcclass',
				title : 'JDBC类',
				width : 60
			}, {
				field : 'sdburl',
				title : '数据库URL',
				width : 50,
				formatter:function(value, row, index){
				  return value.replace("<","\<").replace(">","\>");
				}
			},{
				field : 'sdbschema',
				title : '数据库SCHEMA',
				width : 50
			}, {
				field : 'action',
				title : '动作',
				width : 60,
				formatter : function(value, row, index) {
					if (row.sadminflag == '0') {
						return '';
					} else {
						return formatString('<img onclick="dbquery_list_editFun(\'{0}\');" src="{1}"/>&nbsp;<img onclick="dbquery_list_deleteFun(\'{2}\');" src="{3}"/>', row.sdbtype, '${pageContext.request.contextPath}/js/icons/pencil.png', row.sdbtype, '${pageContext.request.contextPath}/js/icons/cancel.png');
					}
				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					user_list_addFun();
				}
			},'-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					dbquery_list_datagrid.datagrid('reload');
				}
			},'-' ]
		});

	});

	function admin_yhgl_searchFun() {
		dbquery_list_datagrid.datagrid('load', serializeObject($('#dbquery_list_searchForm')));
	}
	function admin_yhgl_cleanFun() {
		$('#dbquery_list_searchForm input').val('');
		dbquery_list_datagrid.datagrid('load', {});
	}
	function dbquery_list_editFun(id) {
		debugger;
		dbquery_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/dbquery_edit.html',
			width : 640,
			height : 410,
			modal : true,
			title : '编辑用户',
			buttons : [ {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#dbquery_edit_editForm').form('submit', {
						url : '${pageContext.request.contextPath}/dbqueryEditAction.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									$('#dbquery_list_datagrid').datagrid('updateRow', {
										index : $('#dbquery_list_datagrid').datagrid('getRowIndex', id),
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
				var index = dbquery_list_datagrid.datagrid('getRowIndex', id);
				var rows = dbquery_list_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#dbquery_edit_editForm').form('load', o);
			}
		});
	}
	function user_list_addFun() {
		$('#dbquery_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/dbquery_add.html',
			width : 640,
			height : 410,
			modal : true,
			title : '添加用户',
			buttons : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#dbquery_add_addForm').form('submit', {
						url : '${pageContext.request.contextPath}/dbqueryAddAction.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									$('#dbquery_list_datagrid').datagrid('insertRow', {
										index : 0,
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
			}
		});
	}
	function dbquery_list_removeFun() {
		var rows = $('#dbquery_list_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
				for ( var i = 0; i < rows.length; i++) {
				  ids.push(rows[i].sdbtype);
				}
	/*			
					var currentUserId = '${session.susercode}';
					var flag = false;
					for ( var i = 0; i < rows.length; i++) {
						if (currentUserId != rows[i].susercode) {
							ids.push(rows[i].susercode);
						} else {
							flag = true;
						}
					}
	*/
					$.ajax({
						url : '${pageContext.request.contextPath}/dbqueryDelAction.html',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								$('#dbquery_list_datagrid').datagrid('load');
								$('#dbquery_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							}
				
								$.messager.show({title : '提示', msg : result.msg});
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
	function dbquery_list_deleteFun(id) {
	    console.info(id);
		$('#dbquery_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('#dbquery_list_datagrid').datagrid('checkRow', $('#dbquery_list_datagrid').datagrid('getRowIndex', id));
		dbquery_list_removeFun();
	}
	
</script>
<div class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 65px;overflow: hidden;" align="center">
		<form id="dbquery_list_searchForm">
			<table class="tableForm">
				<tr>
					<th style="width: 100px;">数据库类型</th>
					<td><input name="sdbtype" style="width: 170px;" /></td>
					<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_yhgl_searchFun();">查询</a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_yhgl_cleanFun();">清空条件</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="dbquery_list_datagrid"></table>
	</div>
</div>