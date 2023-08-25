import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain {

	public static void main(String[] args) {

		// 1. 이전 방식
//		UserService service = new UserService();
//		System.out.println(service.mesg());

		// 2. 스프링 방식

		// ApplicationContext(빈) 에 xml을 알려줌
		// prefix (classpath:, file: , 등등) - 파일 경로만 제대로 되어있으면 찾아줌
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:com/config/user.xml",
				"file:C:\\spring_study\\user2.xml");
	}

}
