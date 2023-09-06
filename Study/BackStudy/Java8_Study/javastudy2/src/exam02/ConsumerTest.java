package exam02;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTest {

	public static void main(String[] args) {

		// 파라미터가 1개인 경우
		// 파라미터 있고 리턴값 없음

		// 익명클래스
		Consumer<String> c = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("Consumer:" + t);
			}
		};
		c.accept("홍길동");

		// 람다표현식 <- 위에꺼가 아닌 이걸 기억해야함
		Consumer<String> c2 = t -> {
			System.out.println("Consumer:" + t);
		};
		c2.accept("홍길동");

		////////////////////////////////////////
		// IntConsumer

		// 익명클래스
		IntConsumer ic = new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println("IntConsumer:" + value);

			}
		};
		ic.accept(10);

		// 람다표현식
		IntConsumer ic2 = value -> {
			System.out.println("람다표현식 IntConsumer:" + value);
		};
		ic2.accept(20);

	} // end main

} // end class
