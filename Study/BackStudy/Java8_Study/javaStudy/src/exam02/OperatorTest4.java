package exam02;

public class OperatorTest4 {

	public static void main(String[] args) {

		// 4. 논리연산자 ( 실행 결과는 논리값 )
		// JS 처럼 임의의 값을 논리값으로 사용 불가

		// 가. &&
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true); // 앞에 false 이므로 뒤에 실행 안함
		System.out.println(false && false); // 앞에 false 이므로 뒤에 실행 안함
		System.out.println();

		// 나. ||
		System.out.println(true || true); // 앞에 true 이므로 뒤에 실행 안함
		System.out.println(true || false); // 앞에 true 이므로 뒤에 실행 안함
		System.out.println(false || true);
		System.out.println(false || false);
		System.out.println();

		// 다. ! ( 부정 )
		System.out.println(!true);
		System.out.println(!false);

	}

}
