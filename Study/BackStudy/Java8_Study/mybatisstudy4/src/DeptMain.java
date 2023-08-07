import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dto.DeptDTO;

public class DeptMain {

	public static void main(String[] args) throws Exception {
		// Configuration.xml 파일읽기
		String resource = "com/config/Configuration.xml"; // 패키지로 되어 있을때 java와 달리 /로 구분해야함
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();

		// Dynamic SQL
		// 1. multi select
		// select * from dept where deptno IN ( 값1, 값2, ... )
		List<Integer> deptnoList = Arrays.asList(10, 20, 30, 40);

		List<DeptDTO> list = session.selectList("DeptDynamicMapper.selectByDeptnoMulti", deptnoList);
		for (DeptDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println();

		// 1. multi select2
		// select * from dept where deptno IN ( 값1, 값2, ... )
		List<DeptDTO> deptnoList2 = Arrays.asList(new DeptDTO(10, "", ""), new DeptDTO(20, "", ""),
				new DeptDTO(40, "", ""));
		List<DeptDTO> list2 = session.selectList("DeptDynamicMapper.selectByDeptnoMulti2", deptnoList2);
		for (DeptDTO dto : list2) {
			System.out.println(dto);
		}
		System.out.println();

		// 2. multi delete
		// delete from dept where deptno IN ( 값1, 값2, ... )
		List<Integer> deptnoList3 = Arrays.asList(50, 51, 60);
		int n = session.delete("DeptDynamicMapper.deleteMulti", deptnoList3);
		System.out.println(n + " 개가 삭제됨");

		session.commit();

		// 3. multi update
		// update dept set dname='개발' where deptno IN (값, 값2, ...)
		List<Integer> deptnoList4 = Arrays.asList(80, 12);
		int n2 = session.update("DeptDynamicMapper.updateMulti", deptnoList4);
		System.out.println(n2 + " 개가 수정됨");

		session.commit();

		// 4. multi insert
		/*
		 * insert all into dept ~ into dept ~ subquery;
		 * 
		 */

//		List<DeptDTO> deptnoList5 = Arrays.asList(new DeptDTO(90, "개발", "서울"), new DeptDTO(91, "개발", "서울"),
//				new DeptDTO(92, "개발", "서울"));
//
//		int n3 = session.insert("DeptDynamicMapper.insertMulti", deptnoList5);
//		System.out.println(n3 + " 개가 저장됨");
//
//		session.commit();

		// 5. 조건 (단일 if만 지원됨, if~else 지원안됨. choose문(조건이 여러개일 때 사용, switch 문과 비슷함))
		// dname 파라미터 값이 null 여부에 따라서 다음 2가지 SQL문 중 하나가 만들어진다.
		// select * from dept where dname = 값; 또는 select * from dept <- dname의 값이 있으면
		// where절이 있고 없으면 where절이 없음
		String dname = "개발"; // 또는 null
		List<DeptDTO> list4 = session.selectList("DeptDynamicMapper.selectAllorDname", dname);
		for (DeptDTO dto : list4) {
			System.out.println(dto);
		}
		System.out.println();
		
		// 6. 다중 조건
		/*
		 * dname = 값에 따라서 select 결과가 달라짐
		 * 
		 * dname값이 '개발' ==> 10,20,30 검색
		 * 				where deptno IN (10,20,30)
		 * dname값이 '영업부' ==> 40 검색
		 * 				where deptno 40
		 * dname값이 모두 만족하지 않으면 ==> 90, 91, 92 검색
		 * 				where deptno IN (90,91,92)
		 * 
		 */
		
		HashMap<String, String> map = new HashMap<>();
		map.put("dname", "개발"); // 영업부, 그 이외 값
		List<DeptDTO> list5 = session.selectList("DeptDynamicMapper.selectByDnameChoose", map);
		for (DeptDTO dto : list5) {
			System.out.println(dto);
		}
		System.out.println();
		

		session.close();

	}

}
