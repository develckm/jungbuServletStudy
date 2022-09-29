package sevlet_study.com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevlet_study.com.dao.ScottDBConn;
import sevlet_study.com.dto.EmpDto;

@WebServlet("/crudEmpUpdate.do")
public class L04CRUDEmpUpdate extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//mgr=&job= : "" 
		String empno_str=req.getParameter("empno"); //pk 바꾸지 않는다.
		String deptno_str=req.getParameter("deptno");
		String mgr_str=req.getParameter("mgr");
		String sal_str=req.getParameter("sal");
		String comm_str=req.getParameter("comm");
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		String hiredate_str=req.getParameter("hiredate"); 
		
		String sql="UPDATE emp SET deptno=?,mgr=?,sal=?,comm=?,ename=?,job=? WHERE empno=?";
		String redirectPage="crudEmpList.do"; //성공했을 때 이동하는 페이지
		String errorPage="crudEmpDetail.do?empno="+empno_str; //실패했을 때 페이지
		Connection conn=null;
		PreparedStatement pstmt=null;
		int update=0; //executeUpdate(DML) 의 결과
		try {
			//Integer i_obj=Integer.valueOf("13"); //문자열을 참조형으로 형변환
			EmpDto emp=new EmpDto();
			emp.setEmpno(Integer.parseInt(empno_str));
			emp.setMgr((mgr_str.equals(""))?null:Integer.valueOf(mgr_str));
			emp.setDeptno((deptno_str.equals("")?null:Integer.valueOf(deptno_str)));
			emp.setSal((sal_str.equals("")?null:Float.valueOf(sal_str)));
			emp.setComm((comm_str.equals("")?null:Float.valueOf(comm_str)));
			emp.setEname((ename.equals("")?null:ename));
			emp.setJob((job.equals("")?null:job));
			//String sql="UPDATE emp SET deptno=?,mgr=?,sal=?,comm=?,ename=?,job=? WHERE empno=?";
			
			conn=ScottDBConn.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1,emp.getDeptno()); //null일수도 있어서
			pstmt.setObject(2, emp.getMgr());
			pstmt.setObject(3, emp.getSal());
			pstmt.setObject(4, emp.getComm());
			pstmt.setString(5, emp.getEname());
			pstmt.setString(6, emp.getJob());
			pstmt.setInt(7, emp.getEmpno());//pk는 null일 수 없다. 
			update=pstmt.executeUpdate();	
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
		System.out.println("update:"+update);
		if(update>0) { //수정 성공
			resp.sendRedirect(redirectPage);
		}else {
			resp.sendRedirect(errorPage);
		}
	}
}
