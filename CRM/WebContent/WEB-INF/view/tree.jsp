<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<link href="/crm/static/css/styles.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EasyUI Tree</title>
	<link rel="stylesheet" type="text/css" href="${ctx }/static/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/static/css/themes/icon.css">
	<script type="text/javascript" src="${ctx }/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx }/static/jquery/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:10px 0;"></div>
	<!-- data-options：url（发送请求）、,method：get方法、animate：动画 -->
	<ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/commons/tree_data1.json',method:'get',animate:true"></ul>
</body>
</html>