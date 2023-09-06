package exam02;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		// 파라미터 한개
		// 익명클래스
		Predicate<String> p = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.length() == 5;
			}
		};
		boolean result = p.test("hello");
		System.out.println("결과: " + result);

		// 람다표현식
		Predicate<String> p2 = t -> t.length() == 5;
		boolean result2 = p2.test("hello");
		System.out.println("람다표현식 결과: " + result2);

		//////////////////////////////////////////////
		// IntPredicate
		// 익명클래스
		IntPredicate pp = new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value > 10;
			}
		};
		boolean result3 = pp.test(5);
		System.out.println("결과: " + result3);

		// 람다표현식
		IntPredicate pp2 = value -> value > 10;
		boolean result4 = pp.test(5);
		System.out.println("람다표현식 결과: " + result4);

		// 파라미터 두개

		BiPredicate<String, Integer> a = new BiPredicate<String, Integer>() {

			@Override
			public boolean test(String t, Integer u) {
				return t.length() == u;
			}
		};
		boolean result5 = a.test("hello", 5);
		System.out.println("결과: " + result5);

		// 람다표현식
		BiPredicate<String, Integer> a2 = (t, u) -> t.length() == u;
		boolean result6 = a.test("hello", 5);
		System.out.println("람다표현식 결과: " + result6);

	}

}
