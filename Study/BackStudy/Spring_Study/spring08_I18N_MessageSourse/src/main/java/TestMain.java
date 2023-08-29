import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {

		// ApplicationContext 가 MessageSource 상속관계임.
//		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");
		MessageSource ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");

		// 리소스 번들(resource bundle)에서 메시지 얻기
		// ctx.getMessage("properties의 key값", "properties에 전달할 값", 일치하는 키캆 업을 시 기본값,
		// 지역명시);
		String mesg = ctx.getMessage("greeting", null, null, Locale.KOREA);
		System.out.println(mesg);
		String mesg2 = ctx.getMessage("greeting", null, null, Locale.ENGLISH);
		System.out.println(mesg2);

		//
		String mesg3 = ctx.getMessage("greeting2", new String[] { "홍길동", "감사합니다." }, null, Locale.ENGLISH);
		System.out.println(mesg3);
		mesg3 = ctx.getMessage("greeting2", new String[] { "이순신", "고맙습니다." }, null, Locale.ENGLISH);
		System.out.println(mesg3);
	}

}
