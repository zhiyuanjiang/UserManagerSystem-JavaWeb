<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>

<h2 style="text-align: center;">欢迎来到学生管理系统</h2>

<table style="text-align: center;" width="350">
	<tr>
		<td style="text-align: right;">账号:</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td style="text-align: right;">密码:</td>
		<td><input type="text" name="id"></td>
	</tr>
</table>

<br>

<%
	session.setAttribute("msg", "null");
%>

<form action="QeuryStuInfoServlet" method="get">
	<input type="submit" value="登录">
</form>

</center>

</body>
</html>