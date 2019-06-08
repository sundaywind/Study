<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EasyUI Tree</title>
	<link href="${ctxStatic}/css/styles.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${ctx }/static/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/static/css/themes/icon.css">
	<script type="text/javascript" src="${ctx }/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx }/static/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			/*  
				jQuery取id：$("#tt") 忘写一个# 搞了半天！
				这是查找jQuery官方文档的tree。
				下面代码表示：
					给id为tt的tree 添加了一个点击事件。而node是JSON文件的一个节点。
			*/
			$("#tt").tree({
				onClick:function(node){
					// 点击当前JSON节点中的text值！
					// alert(node.text);
					// 点击当前JSON节点中的attributes集合中的url值！
					// alert(node.attributes.url)
					if (node.attributes.url) {	
						// 如果node.attributes.url不为空，通过引用tree.jsp的父节点 去替换success.jsp页面中的welcome.jsp页面。（更换url）
						/*  
							window：当前窗口（tree.jsp）
							window.parent：因为tree.jsp被引用到success.jsp的一部分，所以在success.jsp页面中查看 tree.jsp 的parent是success.jsp的14行
							window.parent.doucument：success.jsp的14行 文档。
						*/
						window.parent.document.getElementById("content").src = node.attributes.url;
					}
				}
			})
		})
	</script>
</head>
<body>
	<div style="margin:10px 0;"></div>
	<!-- data-options：url（发送请求）、,method：get方法、animate：动画 -->
	<ul id="tt" class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/commons/tree_data1.json',method:'get',animate:true"></ul>
</body>
</html>