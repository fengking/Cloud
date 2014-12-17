<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(
	$.ajax({
	  url:'${pageContext.request.contextPath}/lastLoginAction.html',
      success:function(result){
	  var r = $.parseJSON(result);
	  if(r.success){
		 for( var i=0; i<r.obj.length; i++){
			 $('#lastloginip').append('<tr align="center" bgcolor="#FAFAF1"><td colspan="2">'+r.obj[i].tsstartdate+'</td><td colspan="2">'+r.obj[i].sip+"</td></tr>");
		 }
	  }else{
		  $.messager.alert({title:'提示',msg : r.msg});
	  }
   }
  })
);
  function sendMail(){
	  $.ajax({
		 url:'${pageContext.request.contextPath}/',
		 data:'',
		 success:function(result){
			 
		 }
	  });
  }
</script>
<div align="center">
<table width="98%" border="0" class="tableForm" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24">${sessionScope.session.susername}个人信息</td>
</tr>
</table>
<fieldset>
          <legend align="left">基本信息</legend>
			<table  width="98%" border="0" cellpadding="2" class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr  align="left" bgcolor="#FAFAF1">
					<th>登录名</th>
					<td>${sessionScope.session.susername}
					</td>
					<th>密码</th>
					<td>******</td>
				</tr>
			</table>
			</fieldset>
			<fieldset>
			<legend align="left">其它信息</legend>
			<table width="98%" border="0" cellpadding="2" class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr align="left" bgcolor="#FAFAF1">
					<th align="right">性别</th>
					<td><c:choose><c:when test="${sessionScope.session.ssex==1}">男</c:when><c:otherwise>女</c:otherwise></c:choose></td>
					<th align="right">出生日期</th>
					<td>${sessionScope.session.dbirthday}</td>
				</tr>
				<tr align="left" bgcolor="#FAFAF1">
					<th>Email</th>
					<td>${sessionScope.session.semail}(<c:choose><c:when test="${sessionScope.session.semailvalflag==1}">已验证</c:when><c:when test="${sessionScope.session.semailvalflag==0}">[<a id="btn" href="#">验证</a>]</c:when><c:otherwise>验证失败</c:otherwise></c:choose>)</td>
					<th>角色</th>
					<td><c:choose><c:when test="${sessionScope.session.sadminflag==0}">普通用户</c:when><c:otherwise>管理员</c:otherwise></c:choose></td>
				</tr>
				<tr align="left" bgcolor="#FAFAF1">
					<th align="right">注册时间</th>
					<td>${sessionScope.session.tsregdatetime}</td>
					<th>注册IP</th>
					<td>${sessionScope.session.slastloginip}</td>
				</tr>
			</table>
			</fieldset>
			<fieldset>
			<legend align="left">最近登陆记录</legend>
			<table id="lastloginip" width="98%" border="0" cellpadding="2" border='1' class="tableForm" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr align="center" bgcolor="#FAFAF1">
					<th>登陆时间</th>
					<th>登陆IP</th>
				</tr>
			</table>
			</fieldset>
</div>