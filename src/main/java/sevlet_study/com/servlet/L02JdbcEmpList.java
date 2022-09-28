package sevlet_study.com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.mysql.cj.jdbc.Driver;
@WebServlet("/jdbcEmpList.do")
public class L02JdbcEmpList extends HttpServlet{
	private static String url="jdbc:mysql://localhost:3306/scott";
	private static String user="root";
	private static String pw="mysql";
	private static String empList="SELECT * FROM EMP";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//dto 작성
		//emp_dept table 출력
		//사번으로 검색 페이지 작성
	}
}










