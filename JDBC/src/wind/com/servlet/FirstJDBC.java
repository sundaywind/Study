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

@WebServlet("/FirstJDBC")
public class FirstJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 连接数据库的四个参数：
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://106.13.108.29:3306/ssms";
	private String userNamne = "root";
	private String password = "7758521";
       
    public FirstJDBC() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		Statement st = null;
		String msg = "";
		try {
			// 1.用反射机制加载MySQL驱动
			Class.forName(driver);
			// 2.建立连接，返回connection对象
			con = DriverManager.getConnection(url, userNamne, password);
			// 3.创建运载命令的Statement对象
			st = con.createStatement();
			// 4.需要执行的SQL命令
			String sql = "INSERT INTO USER(id,`account`, `password`, `name`, `type`) VALUES (null, '2019-7-3', '1234567', '金莲妹妹', '2')";
			// 5.运载SQL，返回结果
			int iCount = st.executeUpdate(sql);
			if (iCount > 0) {
				msg = "SQLִ执行成功";
			}else {
				msg = "SQLִ执行失败";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 6.先创建的后释放，后创建的先释放
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//1. 第一种方法，指定浏览器看这份数据使用的码表
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		//2. 第二种方法，指定输出的中文用的码表
		// response.getOutputStream().write("我爱你..".getBytes("UTF-8"));
		response.getWriter().append("Served at: " + msg).append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
