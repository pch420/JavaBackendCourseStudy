package stu2;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

public class DoubleAndSumMain {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		int sum = numbers.stream()
						 .mapToInt(t->t*2)
						 .sum();
		System.out.println(sum);
			   
	}
}
