<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>云系统  - 志峰创业室 </title>
	<jsp:include page="/inc.jsp"></jsp:include>
	<script type="text/javascript" charset="utf-8"> 
	$(function(){
		debugger;
		if('${sessionScope.session.susername}' == null||'${sessionScope.session.susername}'=="")
		{
			$.messager.show({title:'提示',msg:'您还未登录!请登录后操作...'});
			   setTimeout(function(){
			      window.location.href = 'index.html';
			   }, 1000);
		}
		else
		{
			$.messager.show({
				title : '提示',
				width:230,
				height:150,
				msg : function(){
				    var msg ='${sessionScope.session.susername}'+' 您好!<br/>';
				     if('${sessionScope.session.tslastlogin}' != null && '${sessionScope.session.tslastlogin}' != ''){
				       msg += '上次登陆时间: '+ '${sessionScope.session.tslastlogin}' + '<br/>';
				     }else{
				    	 msg += '欢迎你首次登陆系统!~'+'<br/>';
				     }
				     if('${sessionScope.session.slastloginip}' != null && '${sessionScope.session.slastloginip}' != ''){
				        msg += '上次登陆IP: ' + '${sessionScope.session.slastloginip}' + '<br/>';
				     }
				     msg += '本次登陆IP：' + '${sessionScope.IP}' + '<br/>';
				     if('${sessionScope.session.slastloginip}' != null && '${sessionScope.session.slastloginip}' != '' && '${sessionScope.session.slastloginip}' != '${sessionScope.IP}'){
				    	 msg += '<font color="red">两次登陆IP不一致!</font>';
				     }
				     return msg;
				  }
				});
		}
		});
	
	</script>
  </head>
  
  <body class="easyui-layout">
    <div data-options="region:'north',href:'${pageContext.request.contextPath}/f/layout_north.html'" style="height: 60px;overflow: hidden;"></div>
	<div data-options="region:'west',title:'功能导航',href:'${pageContext.request.contextPath}/f/layout_menu.html'" style="width: 200px;overflow: hidden;"></div>
	<div data-options="region:'center',title:'欢迎使用本系统',href:'${pageContext.request.contextPath}/f/layout_center.html'" style="overflow: hidden;"></div>
	<div data-options="region:'south',href:'${pageContext.request.contextPath}/f/layout_south.html'" style="height: 25px;overflow: hidden;"></div>
  </body>
</html>
