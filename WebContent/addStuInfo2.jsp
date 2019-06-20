<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="stu" class="bean.Student"></jsp:useBean>
	<jsp:setProperty property="*" name="stu"/>
	<%
		String name = stu.getName();
		String id = stu.getId();
		
		if(name == null || name.isEmpty()){ 
			out.print("<script>alert('姓名不能为空'); window.location='addStuInfo.jsp' </script>");
		}else if(id == null || id.isEmpty()){ 
			out.print("<script>alert('学号不能为空'); window.location='addStuInfo.jsp' </script>");
		}else{
			
			int flag = 0;
			if(id.length() != 11 || id.charAt(0) != '2' || 
					id.charAt(1) != '0' || id.charAt(2) != '1' || id.charAt(3) != '6') flag = 1;
			for(int i = 0; i < id.length(); ++i){
				if(id.charAt(i) < '0' || id.charAt(i) > '9') flag = 1;
			}
			
			if(flag == 1){
				out.print("<script>alert('学号格式不对'); window.location='addStuInfo.jsp' </script>");
			}else {
				String user = "root";
				String pwd = "";
				String url = "jdbc:mysql://localhost:3306/test";
				try{
					//加载数据库驱动
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, user, pwd);
					String sql = "insert into student(name,id) values(?,?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, name);
					ps.setString(2, id);
		 			//System.out.println("name:"+stu.getName()+"\n"+"id:"+stu.getId());
					int val = ps.executeUpdate();
					//System.out.print("mmp");
					if(val > 0){
						System.out.println("添加成功"); 
						session.setAttribute("msg", "添加成功");
					}else{
						session.setAttribute("msg", "添加失败");
					}
						
					ps.close();
		   			con.close();   
				}catch(SQLException e){
					System.out.print("sql execute failed"+" "+e.getSQLState());
					session.setAttribute("msg", "添加失败");
				}catch(Exception e){
					System.out.print("jdbc failed");
					session.setAttribute("msg", "添加失败");
				}
				
				response.sendRedirect("QeuryStuInfoServlet");
			}
		}
		
	%>

</body>
</html>