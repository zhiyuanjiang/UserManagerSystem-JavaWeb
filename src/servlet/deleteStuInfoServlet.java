package servlet;

import java.io.IOException;
import java.sql.*;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deleteStuInfoServlet
 */
@WebServlet("/deleteStuInfoServlet")
public class deleteStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteStuInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("start delete");
		String id = request.getParameter("id").toString();
		//System.out.println("name:"+name+"\n"+"id:"+id);
		
		HttpSession session = request.getSession();
		
		String user = "root";
		String pwd = "";
		String url = "jdbc:mysql://localhost:3306/test";
		try{
			//¼ÓÔØÊý¾Ý¿âÇý¶¯
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from student where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
 			//System.out.println("name:"+stu.getName()+"\n"+"id:"+stu.getId());
			int val = ps.executeUpdate();
			if(val > 0) {
				System.out.println("É¾³ý³É¹¦"); 
				session.setAttribute("msg", "É¾³ý³É¹¦");
			}else {
				session.setAttribute("msg", "É¾³ýÊ§°Ü");
			}
				
			ps.close();
   			con.close();   
		}catch(SQLException e){
			System.out.print("sql execute failed"+" "+e.getSQLState());
			session.setAttribute("msg", "É¾³ýÊ§°Ü");
		}catch(Exception e){
			System.out.print("jdbc failed");
			session.setAttribute("msg", "É¾³ýÊ§°Ü");
		}
		
		response.sendRedirect("QeuryStuInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
