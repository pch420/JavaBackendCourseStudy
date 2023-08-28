import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDAO;
import com.service.UserService;

public class UserMain {

	public static void main(String[] args) {

		// IoC Container 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/config/user.xml");

		// 빈 얻기
		UserService service = ctx.getBean("service", UserService.class);
		List<String> list = service.list();
		System.out.println(list);
		System.out.println(service.getNum());
		System.out.println(service.getUsername());

	}

}
