package exam03;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamAPI_03_최종처리_01_allMatch_anyMatch_noneMatch {

	public static void main(String[] args) {

		/*-
		 	최종처리 단계에서 요소들이 특정 조건에 만족여부 확인
		 	가. allMatch(Predicate): 모든 요소들이 Predicate 조건에 일치하는지 체크
		 	나. anyMatch(Predicate): 일부분의 요소들이 Predicate 조건에 일치하는지 체크
		 	다. noneMatch(Predicate): 모든 요소들이 Predicate 조건에 일치하지 않는지 체크
		 	
		 	==> 최종결과는 boolean 값으로 변환
		*/

		int[] arr = { 1, 2, 3, 4, 5 };
		
		// 가. allMatch
		// 익명클래스
		IntPredicate predicate = new IntPredicate() {
			@Override
			public boolean test(int t) {
				return t < 10;
			}
		};

		// 모든 요소가 10보다 작냐?
		boolean result = Arrays.stream(arr)
							   .allMatch(predicate);
		System.out.println("모든 요소가 10보다 작냐?: " + result);
		System.out.println();
		
		// 람다표현식
		result = Arrays.stream(arr)
								.allMatch(t -> t < 10);
		System.out.println("모든 요소가 10보다 작냐?: " + result);
		System.out.println();

		// 나. anyMatch
		
		// 요소중에서 3의 배수가 있냐?
		boolean result2 = Arrays.stream(arr)
								.anyMatch(t -> t % 3 == 0);
		System.out.println("요소중에 3의 배수가 있냐?: " + result2);
		System.out.println();
		
		// 다. noneMatch
		
		// 모든 요소중에서 3의 배수가 없냐?
		boolean result3 = Arrays.stream(arr)
				.noneMatch(t -> t % 3 == 0);
		System.out.println("모든 요소중에서 3의 배수가 없냐?: " + result3);
		System.out.println();
		
		
		
		
		
	} // end main
} // end class
