package exam03;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamAPI_02_중간처리05_boxed_asXXXStream {

	public static void main(String[] args) {

		/*-
		 	boxed()
		 	- 기본형 --> 참조형
		 	
		 	asDoubleStream()
		 	- IntStream --> DoubleStream
		 	  LongStream --> DoubleStream
		*/

		int[] arr = { 1, 2, 3, 4, 5 };
		
		// 가. boxed() : int ---> Integer
		IntStream s = Arrays.stream(arr);
		s.boxed()
		 .forEach(System.out::println);
		System.out.println();
		
		// 나. asDoubleStream() : IntStream --> DoubleStream 
		Arrays.stream(arr)
			  .asDoubleStream()
			  .forEach(System.out::println);
		
	} // end main
} // end class
