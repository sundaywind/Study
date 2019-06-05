<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
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
	<h2>Animation Tree</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>Apply 'animate' property to true to enable animation effect.</div>
	</div>
	<div style="margin:10px 0;"></div>
	<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true"></ul>
</body>
</html>