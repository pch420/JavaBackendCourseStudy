import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;
import com.service.UserService2;
import com.service.UserService3;

public class UserMain3 {

	public static void main(String[] args) {

		// IoC Container 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/config/user3.xml");

		// 빈 얻기
		UserService3 xxx = ctx.getBean("service", UserService3.class);

		List<String> list = xxx.list();
		System.out.println(list);
		System.out.println(xxx.num); // 패키지가 다르면 직접접근이 안되서 UserService3 에 public int num; 으로 줌

	}

}
