package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dao.DeptDAO;
import com.dto.DeptDTO;
import com.exception.DuplicatedDeptnoException;

public class DeptServiceImpl implements DeptService {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "SCOTT";
	String passwd = "TIGER";

	public DeptServiceImpl() {
		try {
			Class.forName(driver); // 드라이버 로딩
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// select 기능하는 메서드
	// Connection 까지만 얻는다. 나머지 작업은 DAO에서 처리
	@Override
	public List<DeptDTO> findAll() {

		List<DeptDTO> list = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd); // Connection 맺기
			// DAO 접근
			DeptDAO dao = new DeptDAO();
			list = dao.findAll(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// insert 기능하는 메서드
	// Connection 까지만 얻는다. 나머지 작업은 DAO에서 처리
	@Override
	public int insert(DeptDTO dto) throws DuplicatedDeptnoException {
		int n = 0;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DAO 연동
			DeptDAO dao = new DeptDAO();
			n = dao.insert(con, dto);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}

	// update 기능하는 메서드
	// Connection 까지만 얻는다. 나머지 작업은 DAO에서 처리
	@Override
	public int update(DeptDTO dto) {
		int n = 0;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DAO 연동
			DeptDAO dao = new DeptDAO();
			n = dao.update(con, dto);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}

	@Override
	public int delete(int deptno) {
		int n = 0;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DAO 연동
			DeptDAO dao = new DeptDAO();
			n = dao.delete(con, deptno);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return n;
	}

	@Override
	public int updateAndDelete(DeptDTO dto, int deptno) {
		int n = 0;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			DeptDAO dao = new DeptDAO();
			//// 트랜젝션 ////
			/*
			 * 둘 다 성공해서 실제 DB 반영 -- commit 또는 둘 중에 하나라도 실패하면 모두 취소 -- rollback
			 */
			con.setAutoCommit(false); // 자동으로 커밋하던걸 비활성화시킴 (한번에 처리하기 위해)
			// 수정
			n = dao.update(con, dto);
			// 삭제
			n = dao.delete(con, deptno);

			//// 트랜젝션 ////
			con.commit(); // 수동으로 커밋

		} catch (SQLException e) {
			try {
				if (con != null)
					con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return n;
	}

}