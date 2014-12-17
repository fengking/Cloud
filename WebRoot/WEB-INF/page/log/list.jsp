<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/inc.jsp"></jsp:include>
   <style>
   .input{
     width: 170px;
   }
   </style>
<script type="text/javascript">
var log_list_treegrid;
	$(function() {
		log_list_treegrid = $('#log_list_treegrid').datagrid({
			url : '${pageContext.request.contextPath}/loglistAction.html',
			idField : 'ilogid',
			fit : true,
			fitColumns : true,
			border : false,
			sortName : 'ilogid',
			sortOrder : 'desc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			pagination : true,
			frozenColumns : [ [ {
				title : '日志编号',
				field : 'ilogid',
				width : 30,
				hidden : true
			}, {
				field : 'susername',
				title : '用户名称',
				width : 70,
				formatter : function( value, row, index){
				 if(value == null){
				    return '未登陆用户';
				 }
				  return value;
				}
			},{
				field : 'sproptype',
				title : '操作类型',
				width : 55,
				formatter : function(value, row, index) {
				  if('1' == value){
				    return '登陆';
				  }else if('2' == value){
				    return '新增';
				  }else if('3' == value){
				    return '修改';
				  }else if('4' == value){
				    return '生成';
				  }else if('5' == value){
				    return '导出';
				  }else if('6' == value){
				    return '查询';
				  }else {
				    return '未知';
				  }
				}
			},{
				field : 'sproceedstate',
				title : '执行状态',
				width : 55,
				formatter : function(value, row, index){
				 if('0' == value){
				   return '失败';
				 }else{
				   return '成功';
				 }
				}
			} ] ],
			columns : [ [ {
				field : 'sip',
				title : 'IP',
				width : 40
			},{
				field : 'sclassname',
				title : '类名',
				width : 60
			},{
				field : 'smethodname',
				title : '执行方法',
				width : 40
			}, {
				field : 'tssysupdate',
				title : '时间',
				width : 50
			}, {
				field : 'tsstartdate',
				title : '开始时间',
				width : 50,
				hidden : false
			}, {
				field : 'tsenddate',
				title : '结束时间',
				width : 50
			},{
				field : 'sdesc',
				title : '描述',
				width : 180
			}] ]
		});
	});

	/**
	 *查询
	 */
	function log_list_searchFun(){
	  console.info(log_list_treegrid);
	  $('#log_list_treegrid').datagrid('load', serializeObject($('#log_list_searchForm')));
	}
	
	/**
	*清空
	*/
	function log_list_cleanFun(){
	  $('#log_list_searchForm input').val('');
	  $('#log_list_treegrid').datagrid('load', {});
	  
	}
</script>
<div class="easyui-layout" data-options="fit : true,border : false">
<div data-options="region:'north',title:'查询条件',border:false" style="height: 165px;overflow: hidden;" align="center">
  	<form id="log_list_searchForm">
			<table class="tableForm">
				<tr>
					<th>用户名称</th>
					<td><input name="susername"/></td>
					<th>IP地址</th>
					<td><input name="sip"/></td>
					<th>时间</th>
					<td><input name="startDate" class="easyui-datebox"  data-options="editable:false"/>至<input name="endDate" class="easyui-datebox"  data-options="editable:false"/></td>
				</tr>
				<tr>
					<th colspan="3" align="center"><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="log_list_searchFun();">查询</a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="log_list_cleanFun();">清空查询条件</a></th>
				</tr>
			</table>
		</form>
</div>
<div data-options="region:'center',border:false">
   <table id="log_list_treegrid"></table>
</div>
</div>