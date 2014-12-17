<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
<form id="user_edit_editForm" method="post">
<table width="98%" border="0" class="tableForm" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24">修改用户</td>
</tr>
</table>
<fieldset>
          <input type="hidden" name="susercode"/>
          <legend align="left">基本信息</legend>
			<table  width="98%" border="0" cellpadding="2" class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr  align="left" bgcolor="#FAFAF1">
					<th>登录名</th>
					<td><input name="susername" class="easyui-validatebox" data-options="required:true,validType:'length[1,32]'"/>
					</td>
					<th>密码</th>
					<td><input type="password" name="suserpwd" class="easyui-validatebox" data-options="validType:'length[6,16]'"/></td>
				</tr>
			</table>
			</fieldset>
			<fieldset>
			<legend align="left">其它信息</legend>
			<table width="98%" border="0" cellpadding="2" class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr align="left" bgcolor="#FAFAF1">
					<th align="right">性别</th>
					<td><input type="radio" name="ssex" value="1" checked="checked" style="width:50px"/>男<input type="radio" name="ssex" value="2" style="width:50px"/>女
					</td>
					<th>出生日期</th>
					<td><input name="dbirthday" class="easyui-datebox"  data-options="required:true,editable:false"/></td>
				</tr>
				<tr align="left" bgcolor="#FAFAF1">
					<th>Email</th>
					<td><input name="semail" class="easyui-validatebox" data-options="required:true,validType:'email'"/></td>
					<th>角色</th>
					<td><input type="radio" name="sadminflag" value="0" checked="checked" style="width:50px"/>普通人员<input type="radio" name="sadminflag" value="1" style="width:50px"/>管理员</td>
				</tr>
			</table>
			</fieldset>
		</form>
</div>