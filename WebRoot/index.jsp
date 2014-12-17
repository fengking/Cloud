<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页  - 志峰创业室</title>
    <jsp:include page="inc.jsp"></jsp:include>
    <style type="text/css">
     body {
    font-family:helvetica,tahoma,verdana,sans-serif;
    padding:20px;
    font-size:13px;
    margin:0;
}
       input  {width:150px}
    </style>
    <script>
    var login_regForm;
    var login_logForm;
    var login_loginDialog;
    var user_reg_regDialog;
       $(function(){
    	  login_logForm = $('#login_loginForm').form({
				url : 'loginAction.html',
				success : function(result) {
					var r = $.parseJSON(result);
					if (r.success) {
						login_loginDialog.dialog('close');
						window.location.href = 'main.jsp';//main.html 配置失效
						
					} else {
						$.messager.show({
							title : '提示',
							msg : r.msg
							});
					}
					
				}
			});

    	 login_regForm = $('#user_reg_regForm').form({
			url : 'regAction.html',
			success : function(result) {
				var r = $.parseJSON(result);
				if (r.success) {
					$('#user_reg_regDialog').dialog('close');
					login_loginDialog.show();
				}
				$.messager.show({
					title : '提示',
					msg : r.msg
				});
			}
		});
		 
    	//创建登陆框
		login_loginDialog = $('#user_login_loginDialog').show().dialog({
			modal : true,
			title : ' ',
			closable : false,
			buttons : [ {
				text : '注册',
				handler : function(){
					user_reg_regDialog.dialog('open');
					user_reg_regDialog.window('center');
				}
			},{
				text : '登录',
				handler : function(){
					console.info(login_logForm);
					login_logForm.submit();
				}
			} ]
		}).window('center');
		
		user_reg_regDialog = $('#user_reg_regDialog').show().dialog({
			modal : true,
			title : '用户注册',
			closed : true,
			width : 310,
			height : 340,
			buttons : [ {
				text : '注册',
				handler : function() {
					login_regForm.submit();
					
				}
			} ]
		}).window('center');
       });
		
    </script>
  </head>
  
  <body>
  <br><br><br><br><br><br><br>
    <div class="easyui-dialog" id="user_login_loginDialog" style="width:310px;height:200px;padding:10px">
      <div style="overflow: hidden;">
			<div align="center">
				<form method="post" id="login_loginForm">
					<table border="0" align="center">
					<tr><th colspan="2">登陆系统</th></tr>
						<tr>
							<th>登录名</th>
							<td><input name="susername" class="easyui-validatebox" data-options="required:true,validType:'length[1,32]'"/></td>
						</tr>
						<tr>
							<th>密码</th>
							<td><input type="password" name="suserpwd" class="easyui-validatebox" data-options="required:true,validType:'length[6,16]'"/></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
    </div>
    <br><br><br><br><br><br><br>
    <div id="user_reg_regDialog" style="display: none;overflow: hidden;">
	<div align="center" fit="true">
		<form method="post" id="user_reg_regForm">
		<fieldset>
          <legend align="left">基本信息</legend>
			<table class="tableForm">
				<tr>
					<th>登录名</th>
					<td><input name="susername" class="easyui-validatebox" data-options="required:true,validType:'length[1,32]'"/>
					</td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input type="password" name="suserpwd" class="easyui-validatebox" data-options="required:true,validType:'length[6,16]'"/></td>
				</tr>
				<tr>
					<th>重复密码</th>
					<td><input type="password" name="rePpwd" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#user_reg_regForm input[name=suserpwd]\']'"/></td>
				</tr>
			</table>
			</fieldset>
			<fieldset>
			<legend align="left">其它信息</legend>
			<table class="tableForm">
				<tr>
					<th>性别</th>
					<td><input type="radio" name="ssex" value="1" checked="checked" style="width:50px"/>男<input type="radio" name="ssex" value="2" style="width:50px"/>女
					</td>
				</tr>
				<tr>
					<th>出生日期</th>
					<td><input name="dbirthday" class="easyui-datebox"  data-options="required:true,editable:false"/></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input name="semail" class="easyui-validatebox" data-options="required:true,validType:'email'"/></td>
				</tr>
			</table>
			</fieldset>
		</form>
	</div>
</div>
  </body>
</html>
