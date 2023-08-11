package com.dto;

// emp 테이블의 하나의 행(레코드)을 저장하는 용도
public class EmpDTO {
	// (empno, ename, job, mgr, hiredate, sal, deptno, comm)
	int empno; // emp테이블의 empno 컬럼 저장
	String ename; // emp테이블의 ename 컬럼 저장
	String job;
	int mgr;
	String hiredate; // emp테이블의 hiredate 칼럼 저장
	int sal; // emp테이블의 sal 컬럼 저장
	int deptno; // emp테이블의 deptno 칼럼 저장
	Integer comm;

	public EmpDTO() {
	}

	public EmpDTO(int empno, String ename, String hiredate, int sal, int deptno) {
		this.empno = empno;
		this.ename = ename;		
		this.hiredate = hiredate;
		this.sal = sal;
		this.deptno = deptno;
		
	}

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

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return empno + "\t" + ename + "\t" + sal + "\t" + hiredate + "\t" + deptno;
	}

}
