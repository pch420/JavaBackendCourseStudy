package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.DeptDTO;
import com.exception.DuplicatedDeptnoException;

// Oracle의 dept테이블 연동하는 클래스
public class DeptDAO {

	// select 기능하는 메서드
	public List<DeptDTO> findAll(Connection con) {
		// DeptDTO 누적용
		List<DeptDTO> list = new ArrayList<DeptDTO>();// 다형성
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select deptno as no, dname, loc from dept order by 1";
			pstmt = con.prepareStatement(sql); // 요청할 SQL문을 전송할 때 사용되는 API인 PreparedStatement 생성
			rs = pstmt.executeQuery(); // SQL문 전송 및 결과값 얻기
			while (rs.next()) { // next 메서드는 레코드가 있는경우 true 없으면 false 반환
				int deptno = rs.getInt("no"); // getInt(1) 가능
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				// 누적
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 역순
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}//

	// insert 작업
	public int insert(Connection con, DeptDTO dto) throws DuplicatedDeptnoException {
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into dept ( deptno, dname, loc) " + " values( ?, ?, ? )";
			pstmt = con.prepareStatement(sql); // 에러발생시
			pstmt.setInt(1, dto.getDeptno()); // deptno 값은 중복되지 않도록 확인할 것.
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
//	    	e.printStackTrace();
			throw new DuplicatedDeptnoException(dto.getDeptno() + " 값이 중복됨");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}

	// update 작업
	public int update(Connection con, DeptDTO dto) {
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "update dept set dname=?, loc=? where deptno=?"; // ?는 바인딩 변수로서 나중에 값을 설정한다.
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(3, dto.getDeptno()); 
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}
	
	// delete
	public int delete(Connection con, int deptno) {
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from dept where deptno = ?"; // ?는 바인딩 변수로서 나중에 값을 설정한다.
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno); 
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}

}