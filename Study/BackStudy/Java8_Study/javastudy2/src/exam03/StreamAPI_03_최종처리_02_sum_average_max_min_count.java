package exam03;

import java.util.Arrays;

public class StreamAPI_03_최종처리_02_sum_average_max_min_count {

	public static void main(String[] args) {

		/*-
		 	통계처리
		 	IntStream, LongStream, DoubleStream 의 집계 메서드
		 	
		 	합계 : sum()
		 	평균 : average()
		 	최대 : max()
		 	최소 : min()
		 	갯수 : count()
		 	
		 	==> 최종결과는 boolean 값으로 변환
		*/
		int[] arr = { 1, 2, 3, 4, 5 };
		
		// 가. 합계
		int sum = Arrays.stream(arr)
						.sum();
		System.out.println("합계: " + sum);
		
		sum = Arrays.stream(arr)
					.filter(n->n%2==0)
					.sum();
		System.out.println("짝수의 합계: " + sum);
		
		// 나. 평균
		double avg = Arrays.stream(arr)
						   .average()
						   .orElse(0.0);
		System.out.println("평균: " + avg);
		
		avg = Arrays.stream(arr)
					.filter(n -> n % 2 == 0)
					.average()
					.orElse(0.0);
		System.out.println("짝수의 평균: " + avg);
		
		// 다. 최대
		int max = Arrays.stream(arr)
						.max()
						.orElse(0);
		System.out.println("최대: " + max);
		
		// 라. 최소
		int min = Arrays.stream(arr)
						.min()
						.orElse(0);
		System.out.println("최소: " + min);
		
		// 마. 갯수
		long count = Arrays.stream(arr)
						   .count();
		System.out.println("갯수: " + count);
		
						  
				
		
		

	} // end main
} // end class
