package sevlet_study.com.dto;
/*
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| EMPNO    | int         | NO   | PRI | NULL    |       |
| ENAME    | varchar(10) | YES  |     | NULL    |       |
| JOB      | varchar(9)  | YES  |     | NULL    |       |
| MGR      | int         | YES  | MUL | NULL    |       |
| HIREDATE | date        | YES  |     | NULL    |       |
| SAL      | float(7,2)  | YES  |     | NULL    |       |
| COMM     | float(7,2)  | YES  |     | NULL    |       |
| DEPTNO   | int         | YES  | MUL | NULL    |       |
+----------+-------------+------+-----+---------+-------+ 
 * 
 * */

import java.util.Date;

public class EmpDto {
	private int empno;   
	private String ename;   
	private String job;     
	private int mgr;     
	private Date hiredate;
	private float sal;     
	private float comm;    
	private int deptno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public float getComm() {
		return comm;
	}
	public void setComm(float comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "\"emp\":{ \"empno\" : " + empno + ",\"ename\" : \"" + ename + "\",\"job\" : \"" + job + "\",\"mgr\" : "
				+ mgr + ",\"hiredate\" : \"" + hiredate + "\",\"sal\" : " + sal + ",\"comm\" : " + comm
				+ ",\"deptno\" : " + deptno + " }";
	}  
	
}







