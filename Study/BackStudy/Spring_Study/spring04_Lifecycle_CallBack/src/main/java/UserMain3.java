import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain3 {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/user3.xml");

		ctx.close(); // DisposableBean.destroy()

	}

}
