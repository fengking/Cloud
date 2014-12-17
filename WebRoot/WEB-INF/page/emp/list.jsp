<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <jsp:include page="/inc.jsp"></jsp:include>
   <style>
   .input{
     width: 170px;
   }
   </style>
<script type="text/javascript">
    var user_list_datagrid = null;
	$(function() {
		user_list_datagrid = $('#user_list_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/usersAction.html',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'susercode',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'susercode',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				field : 'susercode',
				title : '用户代码',
				width : 50,
				checkbox : true
			}, {
				field : 'susername',
				title : '登录名称',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'suserpwd',
				title : '密码',
				width : 40,
				formatter : function(value, row, index) {
					return '******';
				}
			}, {
				field : 'ssex',
				title : '性别',
				width : 20,
				sortable : true,
				formatter : function(value, row, index) {
					if(value == '1'){
						return '男';
					}else{
						return '女';
					}
				}
			}, {
				field : 'dbirthday',
				title : '生日',
				width : 35,
				sortable : true,
				formatter : function(value, row, index) {
					if(value){
					  return row.dbirthday.toString().substring(0, 10);
					}
					return value;
				}
			}, {
				field : 'semail',
				title : '邮箱',
				width : 50,
				sortable : true
			}, {
				field : 'tsregdatetime',
				title : '注册时间',
				width : 55,
				sortable : true
			}, {
				field : 'sregip',
				title : '注册IP',
				width : 40,
			}, {
				field : 'tslastlogin',
				title : '上次登陆时间',
				width : 55,
				sortable : true
			}, {
				field : 'slastloginip',
				title : '上次登陆IP',
				width : 40,
				sortable : true
			}, {
				field : 'suserstate',
				title : '用户状态',
				width : 40,
				formatter : function(value, row, index) {
					if(value == '0'){
						return '锁定';
					}else{
						return '正常';
					}
				}
			}, {
				field : 'action',
				title : '动作',
				width : 40,
				formatter : function(value, row, index) {
					if (row.sadminflag == '1') {
						return '系统用户';
					} else {
						return formatString('<img onclick="user_list_editFun(\'{0}\');" src="{1}"/>&nbsp;<img onclick="user_list_deleteFun(\'{2}\');" src="{3}"/>', row.susercode, '${pageContext.request.contextPath}/js/icons/pencil.png', row.susercode, '${pageContext.request.contextPath}/js/icons/cancel.png');
					}
				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					user_list_addFun();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					user_list_removeFun();
				}
			},'-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					user_list_datagrid.datagrid('reload');
				}
			},'-' ]
		});

	});

	function user_list_serarchFun() {
		user_list_datagrid.datagrid('load', serializeObject($('#user_list_searchForm')));
	}
	function user_list_cleanFun() {
		$('#user_list_searchForm input').val('');
		user_list_datagrid.datagrid('load', {});
	}
	function user_list_editFun(id) {
		user_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/user_edit.html',
			width : 520,
			height : 400,
			modal : true,
			title : '编辑用户',
			buttons : [ {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#user_edit_editForm').form('submit', {
						url : '${pageContext.request.contextPath}/usersEditAction.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									$('#user_list_datagrid').datagrid('updateRow', {
										index : $('#user_list_datagrid').datagrid('getRowIndex', id),
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
				var index = user_list_datagrid.datagrid('getRowIndex', id);
				var rows = user_list_datagrid.datagrid('getRows');
				var o = rows[index];
				o.suserpwd = null;
				$('#user_edit_editForm').form('load', o);
			}
		});
	}
	function user_list_addFun() {
		$('#user_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/user_add.html',
			width : 640,
			height : 400,
			modal : true,
			title : '添加用户',
			buttons : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#user_add_addForm').form('submit', {
						url : '${pageContext.request.contextPath}/usersAddAction.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									$('#user_list_datagrid').datagrid('insertRow', {
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
	function user_list_removeFun() {
		var rows = $('#user_list_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					var currentUserId = '${session.susercode}';/*当前登录用户的ID*/
					var flag = false;
					for ( var i = 0; i < rows.length; i++) {
						if (currentUserId != rows[i].susercode) {
							ids.push(rows[i].susercode);
						} else {
							flag = true;
						}
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/usersDelAction.html',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								$('#user_list_datagrid').datagrid('load');
								$('#user_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							}
							if (flag) {
								$.messager.show({
									title : '提示',
									msg : '不可以删除自己！'
								});
							} else {
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}
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
	function user_list_deleteFun(id) {
		$('#user_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('#user_list_datagrid').datagrid('checkRow', $('#user_list_datagrid').datagrid('getRowIndex', id));
		user_list_removeFun();
	}
	
</script>
<div class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 165px;overflow: hidden;" align="center">
		<form id="user_list_searchForm">
			<table class="tableForm">
				<tr>
					<th style="width: 170px;">检索用户名称(可模糊查询)</th>
					<td><input name="susername" style="width: 315px;" /></td>
				</tr>
				<tr>
					<th>创建时间</th>
					<td><input name="createdatetimeStart" class="easyui-datebox"  data-options="editable:false" />至<input name="createdatetimeEnd" class="easyui-datebox"  data-options="editable:false"/></td>
				</tr>
				<tr>
					<th>最后修改时间</th>
					<td><input name="modifydatetimeStart" class="easyui-datebox"  data-options="editable:false" />至<input name="modifydatetimeEnd" class="easyui-datebox"  data-options="editable:false"/></td>
				</tr>
			</table>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="user_list_serarchFun();">查询</a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="user_list_cleanFun();">清空条件</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="user_list_datagrid"></table>
	</div>
</div>