package exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StreamAPI_04_Optional {

	public static void main(String[] args) {

		/*-
		 	OptionalInt, OptionalDouble, OptionalLong
		 	역할 : 컬렉션에 값이 없을 경우 집계 메서드를 사용하면
		 		   예외 발생된다.
		 		   예외방지 + default 값 설정하는 기능을 제공한다. 
		 	
		*/
		
		// 1. 컬렉션에 값이 존재하는경우
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(25);
		
		OptionalDouble avg = list.stream()
								 .mapToDouble(a->a)
								 .average();
		System.out.println(avg); // OptionalDouble[17.5]
		System.out.println(avg.getAsDouble()); // 17.5
		System.out.println(avg.orElse(0.0)); // 값이 있으면 그 값 출력, 값 없으면 기본값 출력
		
		// 2. 컬렉션에 값이 없는 경우
		List<Integer> list2 = new ArrayList<Integer>();
		OptionalDouble avg2 = list2.stream()
								   .mapToDouble(a->a)
								   .average();
		System.out.println(avg2); // OptionalDouble[17.5]
//		System.out.println(avg2.getAsDouble()); // 예외가 발생된다.
		System.out.println(avg2.orElse(0.0)); // 예외발생 대신에 기본값으로 처리됨.

		
		
		
		
		
	} // end main
} // end class
