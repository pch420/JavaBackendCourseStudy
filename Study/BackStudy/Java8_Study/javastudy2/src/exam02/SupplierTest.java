package exam02;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {

		// 파라미터 없고 리턴값 있음

		// 익명클래스
		Supplier<String> s = new Supplier<String>() {

			@Override
			public String get() {
				return "홍길동";
			}
		};
		String result = s.get();
		System.out.println("result: " + result);

		// 람다표현식
		Supplier<String> s2 = () -> "홍길동";
		String result2 = s2.get();
		System.out.println("람다표현식 result: " + result2);

		/////////////////////////////////////////////////
		// BooleanSupplier

		// 익명클래스
		int num = 10;
		BooleanSupplier x = new BooleanSupplier() {

			@Override
			public boolean getAsBoolean() {
				return num % 2 == 0;
			}
		};
		boolean b = x.getAsBoolean();
		System.out.println("num값이 짝수냐? " + b);

		// 람다표현식
		BooleanSupplier x2 = () -> num % 2 == 0;
		boolean b2 = x2.getAsBoolean();
		System.out.println("람다표현식 num값이 짝수냐? " + b2);
		
		//////////////////////////////////////////////////
		// IntSupplier
		
		// 익명 클래스
		String name = "홍길동";
		IntSupplier y = new IntSupplier() {
			
			@Override
			public int getAsInt() {
				return name.length();
			}
		};
		
		int n = y.getAsInt();
		System.out.println("name 문자열 길이 " + n);

		// 람다표현식
		
		IntSupplier y2 = ()-> name.length();
		
		int n2 = y2.getAsInt();
		System.out.println("람다표현식 name 문자열 길이 " + n2);
		
		

	}

}
