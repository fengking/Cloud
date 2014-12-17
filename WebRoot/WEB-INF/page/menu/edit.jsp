<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center">
<form id="menu_edit_editForm" method="post">
<table width="98%" border="0" class="tableForm" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24">修改菜单</td>
</tr>
</table>
<input type="hidden" name="sprojcode"/>
<fieldset>
<legend align="left">菜单信息</legend>
<table width="98%" border="0" cellpadding="2" class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr align="left" bgcolor="#FAFAF1">
		<td width="15%">菜单名称:</td>
		<td width="35%"><input type="text" name="smenuname" style="width:150px;"  class="easyui-validatebox" data-options="required:true" />&nbsp;</td>
		<td width="15%">菜单路径URL:</td>
		<td width="35%"><input type="text" name="smenuurl" style="width:150px;"  class="easyui-validatebox" data-options="required:true" />&nbsp;</td>
	</tr> 
</table>
</fieldset> 
</form>
</div>