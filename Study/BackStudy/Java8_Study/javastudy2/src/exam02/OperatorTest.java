package exam02;

import java.util.function.BinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class OperatorTest {

	public static void main(String[] args) {

		// 매개변수가 한 개인 경우
		// 익명클래스
		UnaryOperator<String> x = new UnaryOperator<String>() {

			@Override
			public String apply(String t) {
				return t + "~";
			}
		};
		String x2 = x.apply("hello");
		System.out.println("값: " + x2);

		// 람다 표현식
		UnaryOperator<String> y = t -> t + "~";
		String y2 = y.apply("hello");
		System.out.println("람다표현식 값: " + y2);

		////////////////////////////////////////
		// IntUnaryOperator
		// 익명클래스

		IntUnaryOperator k = new IntUnaryOperator() {

			@Override
			public int applyAsInt(int operand) {
				return operand * 2;
			}
		};
		int k2 = k.applyAsInt(100);
		System.out.println("값: " + k2);

		// 람다표현식
		IntUnaryOperator z = operand -> operand * 2;

		int z2 = z.applyAsInt(100);
		System.out.println("람다표현식 값: " + z2);

		// 매개변수가 두 개인 경우
		// 익명클래스
		BinaryOperator<Integer> kkk = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		};
		int kkk2 = kkk.apply(100, 200);
		System.out.println("값: " + kkk2);

		// 람다표현식
		BinaryOperator<Integer> xyz = (t, u) -> t + u;
		int xyz2 = xyz.apply(100, 200);
		System.out.println("람다표현식 값: " + xyz2);

	}

}
