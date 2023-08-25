import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain {

	public static void main(String[] args) {

		// 1. 이전 방식
//		UserService service = new UserService();
//		System.out.println(service.mesg());

		// 2. 스프링 방식

		// ApplicationContext(빈) 에 xml을 알려줌
//		ApplicationContext ctx = new GenericXmlApplicationContext("com/config/user.xml", "com/config/user2.xml");
		// com/config 아래 모든 xml 인식
		ApplicationContext ctx = new GenericXmlApplicationContext("com/config/*.xml"); // 가독성은 떨어짐
	}

}
