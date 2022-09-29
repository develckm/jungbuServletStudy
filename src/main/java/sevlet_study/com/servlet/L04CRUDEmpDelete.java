package sevlet_study.com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevlet_study.com.dao.ScottDBConn;

@WebServlet("/crudEmpDelete.do")
public class L04CRUDEmpDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get방식이지만 처리하는 페이지
		String empno_str=req.getParameter("empno");
		System.out.println(empno_str);
		String redirectPage="crudEmpList.do";
		String errorPage="crudEmpDetail.do?empno="+empno_str;
		String sql="DELETE FROM EMP WHERE empno=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int delete=0;
/*참조의 무결성
ALTER TABLE EMP
ADD FOREIGN KEY (MGR) 
REFERENCES EMP(EMPNO);
on delete restrict; 참조하는 자식이 있으면 삭제할 수 없다 
(셀프조인시 restrict 권장한다.->직접 Null바꾸거나 참조하는 자식들을 삭제 후 삭제 )
on delete set null; 참조하는 자식이 있으면 참조값을 null로 하겠다.
on delete cascade; 참조하는 자식이 있으면 부모와 같이 삭제하겠다.
* */
		
		try {
			conn=ScottDBConn.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empno_str));
			delete=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(delete>0) {
			resp.sendRedirect(redirectPage);
		}else {
			resp.sendRedirect(errorPage);
		}

	}
}
