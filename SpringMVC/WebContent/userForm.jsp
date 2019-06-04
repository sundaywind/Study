<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="user/add">
		用户：<input type="text" name="username"/><br/>
		年龄：<input type="text" name="age"/><br/>
		性别：<input type="radio" name="gender" value="true"/>男
			 <input type="radio" name="gender" value="false"/>女<br/>
		生日：<input type="text" name="birthday"/><br/>
		薪水：<input type="text" name="salary"/><br/>
		
		<input type="submit" value="提交"/>
	</form>
</body>
</html>