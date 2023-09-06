package exam02;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class Calculator {
	public Calculator() {
		System.out.println("Calculator 생성자");
	}

	public Calculator(int x) {
		System.out.println("Calculator 생성자 (int " + x + ") ");
	}

	public Calculator(int x, String x2) {
		System.out.println("Calculator 생성자 (int " + x + ", String " + x2 + ") ");
	}

}

public class MethodReferenceTest {

	public static void main(String[] args) {

		// 1. 생성자 method reference
		// 가. 파라미터 없고 리턴타입이 있음. (기본생성자)
		// 익명클래스
		Supplier<Calculator> s = new Supplier<Calculator>() {
			@Override
			public Calculator get() {
				return new Calculator();
			}
		};

		// 람다표현식
		Supplier<Calculator> s2 = () -> new Calculator();

		// method reference
		Supplier<Calculator> s3 = Calculator::new;
		Calculator c = s3.get();
		System.out.println(c);

		// 나. 파라미터 있고 리턴타입이 있음. 파라미터 한 개인 경우( public Calculator(int x){})
		// 익명클래스
		Function<Integer, Calculator> f = new Function<Integer, Calculator>() {

			@Override
			public Calculator apply(Integer t) {
				return new Calculator();
			}
		};
		// 람다표현식
		Function<Integer, Calculator> f2 = t -> new Calculator(t);

		// method reference
		Function<Integer, Calculator> f3 = Calculator::new;
		Calculator c2 = f3.apply(100);
		System.out.println(c2);

		// 나. 파라미터 있고 리턴타입이 있음. 파라미터 두 개인 경우( public Calculator(int x, String x2){})
		// 익명클래스
		BiFunction<Integer, String, Calculator> x = new BiFunction<Integer, String, Calculator>() {

			@Override
			public Calculator apply(Integer t, String u) {
				return new Calculator(t, u);
			}
		};

		// 람다표현식
		BiFunction<Integer, String, Calculator> x2 = (t, u) -> new Calculator(t, u);

		// method reference
		BiFunction<Integer, String, Calculator> x3 = Calculator::new;
		Calculator c3 = x3.apply(100, "홍길동");
		System.out.println(c3);

	} // end main

} // end class
