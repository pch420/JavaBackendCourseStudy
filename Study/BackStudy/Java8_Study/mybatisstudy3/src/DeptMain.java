import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
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

		// findByDeptno 호출
		DeptDTO dto = session.selectOne("DeptMapper.findbyDeptno", 10);
		System.out.println(dto);
		System.out.println("########################################");

		// findAll 호출
		List<DeptDTO> list = session.selectList("DeptMapper.findAll");
		for (DeptDTO xxx : list) {
			System.out.println(xxx);

		}
		System.out.println("########################################");

		// findbyDeptnoAndDname
		DeptDTO dto2 = new DeptDTO();
		dto2.setDeptno(10);
		dto2.setDname("인사");
		List<DeptDTO> list2 = session.selectList("DeptMapper.findbyDeptnoAndDname", dto2);
		for (DeptDTO xxx : list2) {
			System.out.println(xxx);
		}
		System.out.println("########################################");

		// findbyDeptnoAndDnameMap
		HashMap<String, Object> map = new HashMap<>();
		map.put("key1", 10);
		map.put("key2", "인");

		List<DeptDTO> list3 = session.selectList("DeptMapper.findbyDeptnoAndDnameMap", map);
		for (DeptDTO xxx : list3) {
			System.out.println(xxx);
		}
		System.out.println("########################################");

		// findAll 호출
		RowBounds bounds = new RowBounds(0, 3);
		List<DeptDTO> list4 = session.selectList("DeptMapper.findAllPage", null, bounds);
		for (DeptDTO xxx : list4) {
			System.out.println(xxx);
		}

		session.close();

	}

}
