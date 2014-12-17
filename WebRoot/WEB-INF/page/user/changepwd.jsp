<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<div align="center">
	<form id="user_editpwd_editpwdForm" method="post">
		<table width="98%" border="0" class="tableForm" cellpadding="2"
			cellspacing="1" bgcolor="#D1DDAA" align="center"
			style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="24">修改密码</td>
			</tr>
		</table>
		<fieldset>
			<input type="hidden" name="susercode" value="${sessionScope.session.susercode}"/>
			<legend align="left">修改密码</legend>
			<table width="98%" border="0" cellpadding="2" class="tableForm"
				cellspacing="1" bgcolor="#D1DDAA" align="center"
				style="margin-top:8px">
				<tr align="left" bgcolor="#FAFAF1">
					<th>原密码</th>
					<td><input name="suserpwd" class="easyui-validatebox" data-options="required:true,validType:'length[1,32]'" /></td>
				</tr>
				<tr align="left" bgcolor="#FAFAF1">
					<th>新密码</th>
					<td><input type="password" name="susernewpwd" class="easyui-validatebox" data-options="required:true,validType:'length[6,16]'" /></td>
				</tr>
				<tr align="left" bgcolor="#FAFAF1">
				    <th>重复密码</th>
					<td><input type="password" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#user_editpwd_editpwdForm input[name=susernewpwd]\']'" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</div>