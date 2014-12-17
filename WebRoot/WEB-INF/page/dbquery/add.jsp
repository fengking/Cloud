<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div align="center">
<form id="dbquery_add_addForm" method="post">
<table width="98%" border="0" class="tableForm" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24">新增数据库查询信息</td>
</tr>
</table>
<fieldset>
	<legend align="left">数据库查询信息</legend>
	<table width="98%" border="0" cellpadding="2" class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr  align="left" bgcolor="#FAFAF1">
		   <th>数据库名</th>
		   <td><input name="sdbtype" class="easyui-validatebox" data-options="required:true,validType:'length[1,32]'"/></td>
		   <th>JDBC类名</th>
		   <td><input name="sjdbcclass" class="easyui-validatebox" data-options="required:true,validType:'length[1,42]'"/></td>
		</tr>
		<tr align="left" bgcolor="#FAFAF1">
		<th>JDBC URL</th><td><input name="sdburl" class="easyui-validatebox" data-options="required:true,validType:'length[1,170]'"/></td>
		<th>数据库SCHEMA</th><td><input name="sdbschema" class="easyui-validatebox" data-options="required:true,validType:'length[1,12]'"/></td>
		</tr>
		<tr align="left" bgcolor="#FAFAF1">
		<th>查询表</th>
		<td colspan="3"><textarea name="squerytabinfo" style="width:400px;" rows="3"></textarea></td>
		</tr>
		<tr align="left" bgcolor="#FAFAF1">
		<th>查询表结构</th>
		<td colspan="3"><textarea name="squerycolumn" style="width:400px;" rows="3"></textarea></td>
		</tr>
		<tr align="left" bgcolor="#FAFAF1">
		<th>查询主键</th>
		<td colspan="3"><textarea name="squerypk" style="width:400px;" rows="3"></textarea></td>
		</tr>
	</table>
</fieldset>
</form>
</div>