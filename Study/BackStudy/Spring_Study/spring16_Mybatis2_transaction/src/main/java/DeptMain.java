import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.DeptDTO;
import com.service.DeptService;

public class DeptMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");

		DeptService service = ctx.getBean("service", DeptService.class);

		// 트랜잭션 실습
		try {
			int n = service.tx();
		} catch (Exception e) {
			System.out.println("예외발생");
		}

		// 목록
		List<DeptDTO> list = service.deptList();
		for (DeptDTO dto : list) {
			System.out.println(dto);
		}

	}

}
