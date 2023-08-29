import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain2 {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user2.xml");

		ctx.close(); // DisposableBean.destroy()

	}

}
