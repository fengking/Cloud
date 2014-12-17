<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<<jsp:include page="/inc.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Email认证结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	  $(function(){
		    if('${requestScope.validate}' != '0'){
		       setTimeout(function(){ window.location.href = 'index.html';  }, 1000);
		    }
	      }
	  );
	</script>
 
  </head>
  
  <body>
  <div id="win" class="easyui-window" title="Email校验结果" style="width:600px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closable:false,maximizable:false,minimizable:false,collapsible:false">   
    您好<br>
    &nbsp;&nbsp;&nbsp;<strong>您的Email校验结果：</strong><br>
    &nbsp;&nbsp;&nbsp;<c:choose><c:when test="${requestScope.validate == 0}">校验失败!</c:when><c:otherwise>校验成功</c:otherwise></c:choose><br>
    &nbsp;&nbsp;&nbsp;<c:choose><c:when test="${requestScope.validate == 0}"><strong>原因:</strong><br>&nbsp;&nbsp;&nbsp;${msg}<br>&nbsp;&nbsp;&nbsp;您可以重新发送验证邮件!【<a href="#">点击此处重新发送</a>】<br></c:when>
    &nbsp;&nbsp;&nbsp;<c:otherwise>稍后自动返回首页...</c:otherwise></c:choose>
</div>
  </body>
</html>
