package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {

		// <오라클 DB연동하기 위한 4가지 정보>
		// 1. ojdbc6_g.jar 파일들중에서 가장 핵심되는 클래스명을 지정함
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 오라클 접속 정보를 저장한다.
		// 관리자 계정에서 show parameter db_name; 명령어로 서비스명(DB명)확인해야 한다.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		// 3. 계정명
		String userid = "SCOTT";

		// 4. 비번
		String passwd = "TIGER";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			 e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String sql = "select deptno as no, dname, loc from dept";

			pstmt = con.prepareStatement(sql); // 에러발생시
			rs = pstmt.executeQuery();
			while (rs.next()) { // 행선택
				int deptno = rs.getInt("no");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + "\t" + dname + "\t" + loc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				/*
				close는 역순, 위쪽 try에서 값을 넣는 중간에 에러 발생하면 null값으로 
				RuntimeException 발생할 수 있기 때문에 if문으로 처리
				*/
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
