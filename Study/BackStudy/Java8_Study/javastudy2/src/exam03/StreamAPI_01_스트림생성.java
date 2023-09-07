package exam03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamAPI_01_스트림생성 {

	public static void main(String[] args) {

		// 1. 컬렉션에서 stream생성
		List<String> list = Arrays.asList("홍길동", "이순신", "유관순");
		Stream<String> s = list.stream(); // 중간처리,최종처리 할 수 있는 stream 얻기
		System.out.println("스트림 요소 갯수:" + s.count());

		Consumer<String> c = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		list.stream().forEach(c); // stream은 한번 사용하면 다 소진되서 재사용 못함, 쓰려면 새로 만들어야함
		System.out.println();

		// 람다표현식
		list.stream().forEach(t -> System.out.println(t));
		System.out.println();

		// method reference <- 이걸 사용 권장
		list.stream().forEach(System.out::println);
		System.out.println("#############################");

		// 2. 배열에서 stream생성
		String[] names = { "홍길동1", "이순신1", "유관순1" };

		Stream<String> x = Stream.of(names);
		x.forEach(System.out::println);
		System.out.println();

		Stream<String> x2 = Stream.of(names);
		x2.forEach(System.out::println);
		System.out.println();

		// 3. 리터럴에서 Stream 생성
		Stream<String> y = Stream.of("홍길동1", "이순신1", "유관순1");
		y.forEach(System.out::println);
		System.out.println();

		Stream<Integer> y2 = Stream.of(10, 20, 30);
		y2.forEach(System.out::println);
		System.out.println();

	} // end main
} // end class
