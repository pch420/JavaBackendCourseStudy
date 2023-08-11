import java.util.HashMap;
import java.util.List;

import com.dto.DeptDTO;
import com.service.DeptService;
import com.service.DeptServiceImpl;

public class DeptMain {

	public static void main(String[] args) {

		// 서비스 연동
		// 가. 전체 목록 findAll
		DeptService service = new DeptServiceImpl();
		List<DeptDTO> list = service.findAll();
		for (DeptDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("#############################");
		// 나. findByDeptno
		DeptDTO xxx = service.findByDeptno(20);
		System.out.println(xxx);
		System.out.println("#############################");

		// 다. 저장
//		int n = service.addDept(new DeptDTO(99, "관리", "부산"));
//		System.out.println(n + " 개가 저장됨.");

		// 라. 수정
		HashMap<String, Object> map = new HashMap<>();
		map.put("deptno", 99);
		map.put("dname", "관리과");
		map.put("loc", "부산시");
		int n2 = service.updateDept(map);
		System.out.println(n2 + " 개가 수정됨.");

		// 마. 삭제
		int n3 = service.deleteDept(99);
		System.out.println(n3 + " 개가 삭제됨.");
	}

}
