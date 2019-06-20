<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="bean.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
<table style="text-align: center;" width="650" border="1">
	<tr>
		<td colspan="4"><h2>学生信息</h2></td> <hr>
	</tr>
	<tr style="text-align: center;">
		<td><b>姓名</b></td>
		<td><b>学号</b></td>
		<td><b>修改姓名</b></td>
		<td><b>删除</b></td>
	</tr>
	<%
		List<Student> list = (List<Student>)request.getAttribute("list");
		if(list == null || list.size() < 1){
			out.print("没有数据");
		}else{
			for(int i = 0; i < list.size(); ++i){
	%>
	<tr>
		<td><%=list.get(i).getName() %></td>
		<td><%=list.get(i).getId() %></td>
		<td>
			<form action="updateStuInfoServlet" method="post">
				<input type="text" name="name">
				<input type="hidden" name="id" value="<%=list.get(i).getId() %>">
				<input type="submit" value="修改">
			</form>
		</td>
		<td>
			<a href="deleteStuInfoServlet?id=<%=list.get(i).getId() %>">删除</a>
		</td>
	</tr>
	<%
			}
		}
	%>
	<tr>
		<td colspan="4">
			<a href="addStuInfo.jsp">添加数据</a>
		</td>
	</tr>
</table>
<h2>
<%=session.getAttribute("msg") %>
</h2>

</center>

</body>
</html>