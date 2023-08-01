package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertTest {

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
			// e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String sql = "insert into dept( deptno, dname, loc) " 
						 + " values(?, ?, ?)"; // ? 는 바인딩 변수로서 나중에 값을 설정한다.

			pstmt = con.prepareStatement(sql);
			// ? 대신에 값 설정하기
			/*
			 * 		pstmt.setXXX(?위치, 값)
			 */
			pstmt.setInt(1, 12); // deptno 값은 중복되지 않도록 확인할 것
			pstmt.setString(2, "개발");
			pstmt.setString(3, "서울");
			
			int num = pstmt.executeUpdate();
			System.out.println("레코드 생성갯수:" + num);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				/*
				 * close는 역순, 위쪽 try에서 값을 넣는 중간에 에러 발생하면 null값으로 RuntimeException 발생할 수 있기 때문에
				 * if문으로 처리
				 */
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
