package exam02;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class Calculator2 {
	// 인스턴스 메서드
	public int methodA(int x, int y) {
		return x + y;
	}
}

public class MethodReferenceTest2 {

	public static void main(String[] args) {

		// 2. 인스턴스 메서드 method reference
		// 파라미터 이쏙 리턴타입 있음.
		// 익명클래스
		Calculator2 c = new Calculator2();
		BinaryOperator<Integer> x = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				return c.methodA(t, u);
			}
		};

		// 람다표현식
		BinaryOperator<Integer> x2 = (t, u) -> c.methodA(t, u);

		// method reference
		BinaryOperator<Integer> x3 = c::methodA;
		int result = x3.apply(100, 200);
		System.out.println("결과: " + result);

		////////////////////////////////////////
		// API 클래스 : String 클래스의 인스턴스 메서드 사용하는 경우
		UnaryOperator<String> y = new UnaryOperator<String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		};

		// 람다표현식
		UnaryOperator<String> y2 = t -> t.toUpperCase();

		// method reference
		UnaryOperator<String> y3 = String::toUpperCase;
		String result2 = y3.apply("Hello");
		System.out.println("결과: " + result2);

	} // end main

} // end class
