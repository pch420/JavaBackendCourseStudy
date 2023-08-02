package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.DeptDTO;

// Oracle의 dept테이블 연동하는 클래스
public class DeptDAO {

	//select 기능하는 메서드
	public List<DeptDTO> findAll(Connection con){
		// DeptDTO 누적용
		List<DeptDTO> list = new ArrayList<DeptDTO>();//다형성
		PreparedStatement pstmt=null;
	    ResultSet rs = null;
	    try{
	       String sql = "select deptno as no, dname, loc from dept";
	       pstmt = con.prepareStatement(sql); //에러발생시
	       rs = pstmt.executeQuery();
	       while(rs.next()) {
	    	  int deptno = rs.getInt("no"); // getInt(1) 가능
	    	  String dname = rs.getString("dname");
	    	  String loc = rs.getString("loc");
	    	  DeptDTO dto = new DeptDTO(deptno, dname, loc);
	    	  //누적
	    	  list.add(dto);
	       }
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }finally {
			try {
				//역순
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return list;
	}
}