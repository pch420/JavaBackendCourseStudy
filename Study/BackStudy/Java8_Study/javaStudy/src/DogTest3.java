import java.sql.Date;
//import java.util.Date; // 같은 클래스 import 하면 error

public class DogTest3 {

	public static void main(String[] args) {

		// 패키지가 다르면 기본적으로 접근이 안된다.
		Date d = new Date(25);

		java.util.Date c = new java.util.Date();

	}

}
