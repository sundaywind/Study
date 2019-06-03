<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
		实际开发中用绝对路径，相对路径有可能转偏了。
		${pageContext.request.contextPath}：代表当前项目名。
	-->
	<a href="${pageContext.request.contextPath}/First/success">走</a>
	<hr>
	<form action="/SpringMVC/First/index" method="get">	<!-- 老话常谈：第一个斜杠表示当前项目（当前项目下SpringMVC项目名的/First/index请求URL） -->
		<input type="text" name="username" value="">
		<input type="text" name="age" value="">
		<input type="submit" value="GET提交">
	</form>
	<hr>
	<form action="/SpringMVC/First/index" method="post">	<!-- 老话常谈：第一个斜杠表示当前项目（当前项目下SpringMVC项目名的/First/index请求URL） -->
		<input type="text" name="username" value="">
		<input type="text" name="age" value="">
		<input type="submit" value="POST提交">
	</form>
	<hr>
	<form action="/SpringMVC/First/index" method="post">	<!-- 老话常谈：第一个斜杠表示当前项目（当前项目下SpringMVC项目名的/First/index请求URL） -->
		<!-- 将POST提交 转换为PUT、DELETE请求 -->
		<input type="hidden" name="_method" value="PUT">
		<input type="text" name="username" value="">
		<input type="text" name="age" value="">
		<input type="submit" value="PUT提交">
	</form>
	<hr>
	<form action="/SpringMVC/First/index" method="get">	<!-- 老话常谈：第一个斜杠表示当前项目（当前项目下SpringMVC项目名的/First/index请求URL） -->
		<input type="text" name="username" value=""/> 
		<input type="checkbox" name="hobby" value="glq"/>橄榄球
		<input type="checkbox" name="hobby" value="ymq">羽毛球
		<input type="checkbox" name="hobby" value="ppq">乒乓球
		<input type="submit" value="数组提交">
	</form>
	<hr>
	<form action="/SpringMVC/First/index" method="post">	<!-- 老话常谈：第一个斜杠表示当前项目（当前项目下SpringMVC项目名的/First/index请求URL） -->
		用户名：	<input type="text" name="username"/>
		密码：    	<input type="password" name="pwd"/>
		年龄：	<input type="text" name="age"/>
		Email：	<input type="text" name="Email"/>
		<!-- 连缀 -->
		省：		<input type="text" name="address.province"/>
		市：		<input type="text" name="address.city"/>
		<!-- 数组 -->
		爱好：	<input type="checkbox" name="hobby" value="zq"/>足球
				<input type="checkbox" name="hobby" value="lq"/>蓝球
				<input type="checkbox" name="hobby" value="wq"/>网球
		List集合：
			省：	<input type="text" name="list[0].province"/>
			市：	<input type="text" name="list[0].city"/>
			省：	<input type="text" name="list[1].province"/>
			市：	<input type="text" name="list[1].city"/>
			省：	<input type="text" name="list[2].province"/>
			市：	<input type="text" name="list[2].city"/>
		<input type="submit" value="POJO对象提交">
	</form>
	
</body>
</html>