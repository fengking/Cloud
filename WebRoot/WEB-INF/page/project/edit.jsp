<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center">
<form id="project_edit_editForm" method="post">
<table width="98%" border="0" class="tableForm" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24">修改项目</td>
</tr>
</table>
<input type="hidden" name="sprojcode"/>
<fieldset>
<legend align="left">项目信息</legend>
<table width="98%" border="0" cellpadding="2" class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr align="left" bgcolor="#FAFAF1">
		<td width="15%">项目英文名称:</td>
		<td width="35%"><input type="text" name="sprojname" style="width:150px;"  class="easyui-validatebox" data-options="required:true" />&nbsp;</td>
		<td width="15%">项目中文名称:</td>
		<td width="35%"><input type="text" name="sprojchename" style="width:150px;"  class="easyui-validatebox" data-options="required:true" />&nbsp;</td>
	</tr>
	<tr align="left" bgcolor="#FAFAF1">
		<td width="15%">描述:</td>
		<td width="80%" colspan="3"><textarea rows="3" style="width:400px;" name="sdesc"></textarea>&nbsp;</td>
	</tr>
</table>
</fieldset>
<fieldset>
<legend align="left">数据库信息</legend>
<table width="98%" border="0" cellpadding="2" class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">数据库:</td>
	<td width="35%"><select id="dbtypecombo" class="easyui-combogrid" name="sdbtype" style="width:150px;" data-options="required:true, panelWidth:234,idField:'sdbtype',textField:'sdbtype',url:'${pageContext.request.contextPath}/dbqueryComboAction.html',columns:[[
                {field:'sdbtype',title:'类型',width:50},
                {field:'sdburl',title:'JDBC URL',width:130},
                {field:'sdbschema',title:'SCHEMA',width:50}
            ]],onSelect: function(){var g = $('#dbtypecombo').combogrid('grid'); var r = g.datagrid('getSelected');
            $('input[name=sdburl]').val(r.sdburl);$('input[name=sdbschema]').val(r.sdbschema);
            }"></select>&nbsp;</td>
    <td width="15%">JDBC URL:</td>
	<td width="35%"><input type="text" name="sdburl" style="width:150px;"  class="easyui-validatebox" data-options="required:true" />&nbsp;</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">数据库用户名:</td>
	<td width="35%"><input type="text" name="sdbname" style="width:150px;"  class="easyui-validatebox" data-options="required:true" />&nbsp;</td>
	<td width="15%">数据库密码:</td>
	<td width="35%"><input type="text" name="sdbpwd" style="width:150px;"  class="easyui-validatebox" data-options="required:true" />&nbsp;</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
    <td width="15%">数据库SCHEMA:</td>
	<td width="35%"><input type="text" name="sdbschema" style="width:150px;"  class="easyui-validatebox" data-options="required:true" />&nbsp;</td>
	<td width="15%">所使用框架:</td>
	<td width="35%"><select class="easyui-combobox" name="iframecode" style="width:150px;" data-options="required:true,valueField:'iframecode',textField:'sframename',url:'${pageContext.request.contextPath}/frameComboAction.html'"></select>&nbsp;</td>
</tr>
</table>
</fieldset>
</form>
</div>