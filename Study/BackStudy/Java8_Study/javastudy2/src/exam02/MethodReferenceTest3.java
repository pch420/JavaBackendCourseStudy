package exam02;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

class Calculator3 {
	// 인스턴스 메서드
	public static int methodA(int x, int y) {
		return x + y;
	}
}

public class MethodReferenceTest3 {

	public static void main(String[] args) {

		// 3. static 메서드 method reference)
		// 파라미터 있고 리턴타입 있음
		// 익명 클래스
		BinaryOperator<Integer> x = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return Calculator3.methodA(t, u);
			}
		};

		// 람다표현식
		BinaryOperator<Integer> x2 = (t, u) -> Calculator3.methodA(t, u);

		// method reference
		BinaryOperator<Integer> x3 = Calculator3::methodA;
		int result = x2.apply(100, 200);
		System.out.println("결과:" + result);

		///////////////////////////////////////////////////
		// API 중에서 대표적인 static 메서드: Integer.paseInt("10"), String.valueOf(10)

		// int xxx = Integer.parseInt("10");
		// 익명클래스
		Function<String, Integer> y = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};

		// 람다표현식
		Function<String, Integer> y2 = t -> Integer.parseInt(t);

		// method reference
		Function<String, Integer> y3 = Integer::parseInt; // 중요
		int result2 = y3.apply("100");
		System.out.println("결과:" + result2);

	} // end main

} // end class
