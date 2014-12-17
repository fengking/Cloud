<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/inc.jsp"></jsp:include>
   <style>
   .input{
     width: 170px;
   }
   </style>
<script type="text/javascript">
var menu_list_datagrid;
	$(function() {
		menu_list_datagrid = $('#menu_list_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/menulistAction.html',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'imenuid',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'imenuid',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				title : '菜单名称',
				field : 'smenuname',
				width : 50,
				checkbox : true
			}, {
				field : '菜单url',
				title : 'smenuurl',
				width : 70
			} 
			, {
				field : 'action',
				title : '动作',
				width : 50,
				formatter : function(value, row, index) {
					return formatString('<img onclick="menu_list_editFun(\'{0}\');" src="{1}"/>&nbsp;<img onclick="menu_list_deleteFun(\'{2}\');" src="{3}"/>', row.sprojcode, '${pageContext.request.contextPath}/js/icons/pencil.png', row.sprojcode, '${pageContext.request.contextPath}/js/icons/cancel.png');
				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					menu_list_addFun();
				}
			} ,'-', {
				text : '批量删除',
				iconCls : 'icon-cancel',
				handler : function() {
					menu_list_removeFun();
				}
			} ,'-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					menu_list_datagrid.datagrid('reload');
				}
			},'-']
		});
	});
	
/**
 * 增加菜单
 */
	function menu_list_addFun() {
	
	    menu_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/menu_add.html',
			width : 700,
			height : 420,
			modal : true,
			title : '菜单添加',
			buttons : [ 
			 {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#menu_add_addForm').form('submit', {
						url : '${pageContext.request.contextPath}/addmenuAction.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									menu_list_datagrid.datagrid('insertRow', {
										index : 0,
										row : r.obj
									});
									d.dialog('destroy');
									//使用ajax在添加过菜单后自动解析数据库表
									$.ajax({
	     	 							url:'${pageContext.request.contextPath}/structsDbAction.html',
	     								data: 'menu.sprojcode=' + r.obj.sprojcode,
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
	function menu_list_removeFun() {
		var rows = menu_list_datagrid.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的菜单?', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].sprojcode);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/delmenuAction.html',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								menu_list_datagrid.datagrid('load');
								menu_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	function menu_list_deleteFun(id) {
		menu_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		menu_list_datagrid.datagrid('checkRow', menu_list_datagrid.datagrid('getRowIndex', id));
		menu_list_removeFun();
	}
	
	/**
	*修改菜单
	*/
	function menu_list_editFun(id) {
/*
		if (id != undefined) {
			menu_list_datagrid.datagrid('selectRow', id);
		}
		var rows = menu_list_datagrid.datagrid('getChecked');
		console.info(rows);
		if(rows.length > 0){
		  $.messager.show({title : '提示',msg : '请选中一条记录进行修改!'});
		  */
		  menu_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		/*
		  return;
		}
		*/
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/menu_edit.html',
			width : 700,
			height : 420,
			modal : true,
			title : '菜单修改',
			buttons : [ {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#menu_edit_editForm').form('submit', {
						url : '${pageContext.request.contextPath}/editmenuAction.html',
						
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									menu_list_datagrid.datagrid('updateRow', {
										index : menu_list_datagrid.datagrid('getRowIndex', id),
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
				var index = menu_list_datagrid.datagrid('getRowIndex', id);
				var rows = menu_list_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#menu_edit_editForm').form('load', o);
			}
		});
	}
	
	/**
	 *菜单查询
	 */
	function menu_list_searchFun(){
	 menu_list_datagrid.datagrid('load', serializeObject($('#menu_list_searchForm')));
	}
	
	/**
	*清空
	*/
	function menu_list_cleanFun(){
	  $('#menu_list_searchForm input').val('');
	  menu_list_datagrid.datagrid('load', {});
	}
</script>
<div class="easyui-layout" data-options="fit : true,border : false">
<div data-options="region:'north',title:'查询条件',border:false" style="height: 185px;overflow: hidden;" align="center">
  	<form id="menu_list_searchForm">
			<table class="tableForm">
				<tr>
					<th style="width: 170px;">菜单名称</th>
					<td><input name="smenuname"/></td> 
				</tr> 
			</table>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="menu_list_searchFun();">查询</a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="menu_list_cleanFun();">清空查询条件</a>
		</form>
</div>
<div data-options="region:'center',border:false">
   <table id="menu_list_datagrid"></table>
</div>
</div>