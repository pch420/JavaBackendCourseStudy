import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.DeptDTO;
import com.service.DeptService;

public class DeptMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");

		DeptService service = ctx.getBean("service", DeptService.class);
		
		// 저장 (스프링에서는 자동 commit)
//		DeptDTO xxx = new DeptDTO(13, "개발", "서울");
//		int n = service.deptAdd(xxx);

		// 수정
//		DeptDTO xxx2 = new DeptDTO(13, "개발부", "서울시");
//		int n2 = service.deptUpdate(xxx2);
		
		// 삭제
//		int n3 = service.deptDelete(13);
		
		// 목록
		List<DeptDTO> list = service.deptList();
		for (DeptDTO dto : list) {
			System.out.println(dto);
		}



	}

}
