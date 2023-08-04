import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dto.DeptDTO;

public class DeptMain2 {

	public static void main(String[] args) throws Exception {
		// Configuration.xml 파일읽기
		String resource = "com/config/Configuration.xml"; // 패키지로 되어 있을때 java와 달리 /로 구분해야함
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		// insert 작업
//		DeptDTO dto = new DeptDTO(99, "개발", "서울");
//		int n = session.insert("DeptMapper2.addDept", dto);
//		System.out.println(n + " 개가 저장됨");
//		session.commit();

		// update 작업
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("deptno", 99);
//		map.put("dname", "개발부");
//		map.put("loc", "서울시");
//		int n2 = session.update("DeptMapper2.updateDept", map);
//		System.out.println(n2 + " 개가 수정됨");
//		session.commit(); // 트랜잭션 종료
		
		// delete 작업
		int n3 = session.delete("DeptMapper2.deleteDept",99);
		System.out.println(n3 + " 개가 삭제됨");
		session.commit(); // 트랜잭션 종료
		
		session.commit();
		
		session.close();

	}

}
