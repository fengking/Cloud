<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="utf-8">
var centerTabs;
var tabsMenu;
$(function() {
	
	tabsMenu = $('#tabsMenu').menu({
		onClick : function(item) {
			var curTabTitle = $(this).data('tabTitle');//获得当前tab标题
			var type = $(item.target).attr('type');//获取当前tab类型

			if (type === 'refresh') {
				refreshTab( centerTabs, curTabTitle);
				return;
			}

			if (type === 'close') {
				var t = centerTabs.tabs('getTab', curTabTitle);
				if (t.panel('options').closable) {
					centerTabs.tabs('close', curTabTitle);
				}
				return;
			}
			if(type=='closeleft')
			{
				var prevall = $('.tabs-selected').prevAll();
				if(prevall.length==0){
					msgShow('系统提示','后边没有啦~~','info'); 
					return false;
				}
				prevall.each(function(i,n){
					var t=$('a:eq(0) span',$(n)).text();
					$('#centerTabs').tabs('close',t);
				});
				return;

			}
			if(type=='closeright')
			{
				var nextall = $('.tabs-selected').nextAll();
				if(nextall.length==0){
					msgShow('系统提示','后边没有啦~~','info');
					 
					return false;
				}
				nextall.each(function(i,n){
					debugger;
					var t=$('a:eq(0) span',$(n)).text();
					$('#centerTabs').tabs('close',t);
				});
				return ;
			}

			var allTabs = centerTabs.tabs('tabs');
			var closeTabsTitle = [];

			$.each(allTabs, function() {
				var opt = $(this).panel('options');
				if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
					closeTabsTitle.push(opt.title);
				} else if (opt.closable && type === 'closeAll') {
					closeTabsTitle.push(opt.title);
				}
			});

			for ( var i = 0; i < closeTabsTitle.length; i++) {
				centerTabs.tabs('close', closeTabsTitle[i]);
			}
		}
	});
	
	centerTabs = $('#centerTabs').tabs({
		fit : true,
		border : false,
		onContextMenu : function(e, title) {
			e.preventDefault();
			tabsMenu.menu('show', {
				left : e.pageX,
				top : e.pageY
			}).data('tabTitle', title);
		}
	});
	
	//关闭当前右侧的TAB
	/* $('#mm-tabcloseright').click(function(){
		debugger;
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			msgShow('系统提示','后边没有啦~~','error');
			//alert('后边没有啦~~');
			//msgShow
			return false;
		}
		nextall.each(function(i,n){
			debugger;
			var t=$('a:eq(0) span',$(n)).text();
			$('#centerTabs').tabs('close',t);
		});
		return false;
	}); */
	
	//关闭当前左侧的TAB
	/* $('#mm-tabcloseleft').click(function(){
		debugger;
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			msgShow('系统提示','后边没有啦~~','info');
			//alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#centerTabs').tabs('close',t);
		});
		return false;
	}); */
	//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
	function msgShow(title, msgString, msgType) {
		$.messager.alert(title, msgString, msgType);
	}
});
</script>
<div id="centerTabs"style="overflow: hidden;">
  
</div>
<div id="tabsMenu" style="width: 120px;display:none;">
	<div type="refresh">刷新</div>
	<div class="menu-sep"></div>
	<div type="close">关闭</div>
	<div type="closeOther">关闭其他</div>
	<div type="closeAll">关闭所有</div>
	<div type="closeright" id="mm-tabcloseright">
            当前页右侧全部关闭</div> 
     <div type="closeleft" id="mm-tabcloseleft">
            当前页左侧全部关闭</div>
</div>