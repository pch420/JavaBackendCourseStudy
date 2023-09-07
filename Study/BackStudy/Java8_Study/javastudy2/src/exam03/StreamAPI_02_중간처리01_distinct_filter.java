package exam03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPI_02_중간처리01_distinct_filter {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("홍길동", "이순신", "유관순", "이순신", "이만수");
		
		// 1. 중간처리 - 중복제거
		list.stream()
			.distinct()
			.forEach(System.out::println);
		System.out.println();

		// 2. 중간처리 (필터링-filter)
		// 익명함수
		Predicate<String> predicate = new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				return t.startsWith("이");
			}
		};
		
		list.stream()
			.filter(predicate) // 리턴 타입 true 인 애들만 통과
			.forEach(System.out::println);
		System.out.println();
		
		// 람다표현식
		list.stream()
			.filter(t->t.startsWith("이"))
			.forEach(System.out::println);
		System.out.println();		
		
		// 3. 혼합 (distinct + filter)
		list.stream()
			.distinct()
			.filter(t -> t.startsWith("이"))
			.forEach(System.out::println);		
		System.out.println();		
		
		
	} // end main
} // end class
