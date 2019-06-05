package wind.com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstJDBC
 */
@WebServlet("/FirstJDBC")
public class FirstJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://106.13.108.29:3306/ssms";
	private String userNamne = "root";
	private String password = "7758521";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstJDBC() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		Statement st = null;
		String msg = "";
		try {
			// ����������������ƣ�
			Class.forName(driver);
			// ��������
			con = DriverManager.getConnection(url, userNamne, password);
			// ����ִ��SQL�Ķ���
			st = con.createStatement();
			// ��Ҫִ�е�SQL
			String sql = "INSERT INTO USER(id,`account`, `password`, `name`, `type`) VALUES ('100', '20190506', '111111', '������', '1')";
			// ����ִ��SQL
			int iCount = st.executeUpdate(sql);
			if (iCount > 0) {
				msg = "SQLִ执行成功";
			}else {
				msg = "SQLִ执行失败";
			}
		} catch (ClassNotFoundException e) {
			// ��������������쳣
			e.printStackTrace();
		} catch (SQLException e) {
			// ����DriverManager�������쳣
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		response.getWriter().append("Served at: " + msg).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
