import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.service.UserService;

public class TestMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");

		// singleton은 하나의 인스턴스로 여러 사용자가 사용하기 때문에 공유된다.
		UserService s1 = ctx.getBean("service", UserService.class);
		UserService s2 = ctx.getBean("service", UserService.class);
		System.out.println("singleton:" + (s1 == s2)); // singleton:true

		s1.username = "홍길동";
		s2.username = "이순신";
		System.out.println(s1.username + "\t" + s2.username); // 이순신 이순신

		// prototype 은 매번 생성되기 때문에 자신만의 데이터 유지가 가능하다.
		UserService s3 = ctx.getBean("service2", UserService.class);
		UserService s4 = ctx.getBean("service2", UserService.class);
		System.out.println("prototype:" + (s3 == s4)); // prototype:false

		s3.username = "유관순";
		s4.username = "강감찬";
		System.out.println(s3.username + "\t" + s4.username); // 유관순 강감찬

	}

}
