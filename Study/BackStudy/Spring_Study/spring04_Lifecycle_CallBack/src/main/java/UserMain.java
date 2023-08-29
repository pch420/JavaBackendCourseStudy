import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user.xml");

		ctx.close();
	}

}
