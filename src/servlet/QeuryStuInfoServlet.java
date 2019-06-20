package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.*;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import bean.Student;

/**
 * Servlet implementation class QeuryStuInfoServlet
 */
@WebServlet("/QeuryStuInfoServlet")
public class QeuryStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QeuryStuInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = "root";
		String pwd = "";
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con = null;
		Statement state = null;
		java.util.List<Student> list = new ArrayList<Student>();
		
		try{
			System.out.println("show student info");
			//注册jdbc驱动
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			
			//System.out.println("实例化statement对象");
			state = con.createStatement();
			
			String sql = "select * from student";
			ResultSet st = state.executeQuery(sql);
			
			while(st.next()){
				String id = st.getString("id");
				String name = st.getString("name");
				
				Student stu = new Student(name, id);
				list.add(stu);
			}
			
			request.setAttribute("list", list);
			
			st.close();
			state.close();
			con.close();
		}catch(SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("数据库驱动出了问题");
			e.printStackTrace();
		}
		
		//重定向
		request.getRequestDispatcher("showStuInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
