package stu1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterNumberMain {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numbers.stream()
			   .filter(t -> t % 3 == 0)
			   .forEach(System.out::println);

	}
}
