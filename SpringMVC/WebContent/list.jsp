<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		alert("这是测试静态资源");
	</script>
	<img alt="" src="${pageContext.request.contextPath}/static/img/jx.png">
	这是List.jsp页面
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				$.ajax({
					type : "get",
					url  :	"${pageContext.request.contextPath}/First/toJson",
					data :	{},
					success : function(msg) {
						for (var i = 0; i < msg.length; i++) {
							alert(msg[i].username);
						}
					}
				})
			})
		})
	</script>
	<input id="btn" type="button" value="发送ajax获取JSON数据"/>
</body>
</html>