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
<form action="addStuInfo2.jsp" method="post">
	<table style="text-align: center;" width="350">
		<tr>
			<td colspan="2" style="text-align: center;">
				<h2>添加学生信息</h2>
				<hr>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">姓名：</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td style="text-align: right;">学号：</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"><input type="submit" value="添加"></td>
		</tr>
	</table>
</form>
</center>

</body>
</html>