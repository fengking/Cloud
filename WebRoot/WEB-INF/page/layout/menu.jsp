<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript" charset="utf-8">
	var ctrlTree;
	$(function() {

		ctrlTree = $('#ctrlTree').tree({
			url : '${pageContext.request.contextPath}/menuAction.html',
			lines : true,
			onClick : function(node) {
				addTab( centerTabs, node);
			},
			onDblClick : function(node) {
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					} else {
						$(this).tree('collapse', node.target);
					}
				
			}
		});

	});
</script>
<div class="easyui-accordion" data-options="fit:true,border:false">
	<div title="系统菜单" data-options="isonCls:'icon-save',tools : [ {
				iconCls : 'icon-reload',
				handler : function() {
					ctrlTree.tree('reload');
				}
			}, {
				iconCls : 'icon-redo',
				handler : function() {
					var node = ctrlTree.tree('getSelected');
					if (node) {
						ctrlTree.tree('expandAll', node.target);
					} else {
						ctrlTree.tree('expandAll');
					}
				}
			}, {
				iconCls : 'icon-undo',
				handler : function() {
					var node = ctrlTree.tree('getSelected');
					if (node) {
						ctrlTree.tree('collapseAll', node.target);
					} else {
						ctrlTree.tree('collapseAll');
					}
				}
			} ]">
		<ul id="ctrlTree" style="margin-top: 5px;"></ul>
	</div>
</div>
