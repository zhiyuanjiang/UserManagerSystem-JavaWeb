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
 * Servlet implementation class updateStuInfoServlet
 */
@WebServlet("/updateStuInfoServlet")
public class updateStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStuInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("start update");
		String name = request.getParameter("name").toString();
		String id = request.getParameter("id").toString();
		
		HttpSession session = request.getSession();
		
		String user = "root";
		String pwd = "";
		String url = "jdbc:mysql://localhost:3306/UserManageSystem";
		try{
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "update student set name = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, id);
 			//System.out.println("name:"+stu.getName()+"\n"+"id:"+stu.getId());
			int val = ps.executeUpdate();
			if(val > 0) {
				System.out.println("���³ɹ�"); 
				session.setAttribute("msg", "���³ɹ�");
			}else {
				session.setAttribute("msg", "����ʧ��");
			}
				
			ps.close();
   			con.close();   
		}catch(SQLException e){
			System.out.print("sql execute failed"+" "+e.getSQLState());
			session.setAttribute("msg", "����ʧ��");
		}catch(Exception e){
			System.out.print("jdbc failed");
			session.setAttribute("msg", "����ʧ��");
		}
		
		response.sendRedirect("QeuryStuInfoServlet");
	}

}
