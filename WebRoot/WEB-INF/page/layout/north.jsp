<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
   function logout(flag){
		$.ajax({
		url:'${pageContext.request.contextPath}/logoutAction.html',
		success:function(result){
		var r = $.parseJSON(result);
		  if(r.success){
		   $.messager.show({title:'提示',msg:'您已退出成功!即将返回首页...'});
		   setTimeout(function(){
		      window.location.href = 'index.html';
		   }, 1000);
		  }
		}
		});
	}
   
	/*
	 *查看个人信息 
	 */
   function showUserInfo(){
	   $('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/user_userinfo.html',
			width : 700,
			height : 460,
			modal : true,
			title : '${sessionScope.session.susername}-个人信息',
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
   }
   
   function changePwd(){
		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/user_changepwd.html',
			width : 300,
			height : 280,
			modal : true,
			title : '${sessionScope.session.susername}-修改密码',
			buttons : [ {
				text : '修改密码',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#user_editpwd_editpwdForm').form('submit', {
						url : '${pageContext.request.contextPath}/changePwdAction.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									d.dialog('destroy');
								}
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
							} catch (e) {
								$.messager.alert('提示', result);
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
   
   function editUserInfo(){

		$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/f/user_editinfo.html',
			width : 520,
			height : 400,
			modal : true,
			title : '${sessionScope.session.susername}-修改个人信息',
			buttons : [ {
				text : '修改密码',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#user_editpwd_editpwdForm').form('submit', {
						url : '${pageContext.request.contextPath}/f/user_edit.html',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									d.dialog('destroy');
								}
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
							} catch (e) {
								$.messager.alert('提示', result);
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	  
   }
</script>
<div id="sessionInfoDiv" style="position: absolute;right: 5px;top:10px;">
	<c:if test="${sessionScope.session.susercode != null}">[<strong>${sessionScope.session.susername}</strong>]，欢迎你！您使用[<strong>${sessionScope.IP}</strong>]IP登录！</c:if>
</div>
<div style="position: absolute; right: 0px; bottom: 0px; ">
	<a href="javascript:void(0);" class="easyui-menubutton"
		data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a>
	<a href="javascript:void(0);" class="easyui-menubutton"
		data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
	<a href="javascript:void(0);" class="easyui-menubutton"
		data-options="menu:'#layout_north_zxMenu',iconCls:'icon-back'">注销</a>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeTheme('default');">default</div>
	<div onclick="changeTheme('gray');">gray</div>
	<div onclick="changeTheme('bootstrap');">bootstrap</div>
	<div onclick="changeTheme('black');">black</div>
	<div onclick="changeTheme('metro');">metro</div>
	<div onclick="changeTheme('ui-cupertino');">ui-cupertino</div>
	<div onclick="changeTheme('ui-dark-hive');">ui-dark-hive</div>
	<div onclick="changeTheme('ui-pepper-grinder');">ui-pepper-grinder</div>
	<div onclick="changeTheme('ui-sunny');">ui-sunny</div>
</div>
<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	<div onclick="showUserInfo();">个人信息</div>
	<div onclick="editUserInfo();">修改个人信息</div>
	<div onclick="changePwd();">修改密码</div>
	<div class="menu-sep"></div>
	<div>
		<span>更换主题</span>
		<div style="width: 120px;">
			<div onclick="changeTheme('default');">default</div>
			<div onclick="changeTheme('gray');">gray</div>
			<div onclick="changeTheme('bootstrap');">bootstrap</div>
			<div onclick="changeTheme('black');">black</div>
			<div onclick="changeTheme('metro');">metro</div>
			<div onclick="changeTheme('ui-cupertino');">ui-cupertino</div>
			<div onclick="changeTheme('ui-dark-hive');">ui-dark-hive</div>
			<div onclick="changeTheme('ui-pepper-grinder');">ui-pepper-grinder</div>
			<div onclick="changeTheme('ui-sunny');">ui-sunny</div>
		</div>
	</div>
</div>
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div class="menu-sep"></div>
	<div onclick="logout(true);" data-options="">退出系统</div>
</div>
