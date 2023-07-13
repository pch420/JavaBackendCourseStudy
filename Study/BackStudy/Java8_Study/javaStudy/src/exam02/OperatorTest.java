package exam02;

public class OperatorTest {

	public static void main(String[] args) {

		// 1. 산술 연산자
		int n = 10;
		int n2 = 3;
		
		System.out.println(n+n2);
		System.out.println(n-n2);
		System.out.println(n*n2);
		System.out.println(n/n2); // 몫만 반환
		
		float f = n/n2;
		System.out.println(f); // 3.0
		System.out.println(n/3.0); // 3.333333 <- 연산할 때 실수랑 해야됨		
		
		System.out.println(n%n2);
		
		// + : 연결연산자로서 사용가능
		String k = 10 + 20 + 30 + "hello"; 
		String k2 = "hello" + 10 + 20 + 30; 
		System.out.println(k); // 60hello
		System.out.println(k2); // hello102030
		

	}

}
