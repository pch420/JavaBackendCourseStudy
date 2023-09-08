import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Algo03_선형구조_01_배열2 {

	public static void main(String[] args) {

		// Arrays 클래스

		// 1. 리스트 생성
		List<String> list = Arrays.asList("A", "B");

		// 2. 임의의 값으로 채우기
		String[] name = { "A", "B", "C" };
		Arrays.fill(name, "x"); // 전체값을 "x"로 채우기 [x, x, x]
		System.out.println("2-1. 임의의 값으로 채우기: " + Arrays.toString(name));

		Arrays.fill(name, 0, 2, "A"); // 0부터 2전까지를 "A"로 채우기 [A, A, x]
		System.out.println("2-2. 일부분 임의의 값으로 채우기: " + Arrays.toString(name));

		// 3. 배열값 비교
		int[] n = { 1, 2, 3 };
		int[] n2 = { 1, 2, 3 };
		System.out.println("3. 배열값 비교: " + Arrays.equals(n, n2)); // true

		// 4. 정렬
		Integer[] n3 = { 6, 2, 7, 98, 24 };
		Arrays.sort(n3); // 오름차순 정렬
		System.out.println("4-1. 오름차순 정렬: " + Arrays.toString(n3)); // [2, 6, 7, 24, 98]
		// Comparator.reverseOrder() 사용하기 위해서는 클래스타입이어야 됨.
		Arrays.sort(n3, Comparator.reverseOrder()); // 내림차순 정렬
		System.out.println("4-2. 내림차순 정렬: " + Arrays.toString(n3)); // [2, 6, 7, 24, 98]

		// 5. 특정 값의 위치 검색
		int[] n4 = { 6, 2, 7, 98, 24 };
		int idx = Arrays.binarySearch(n4, 98); // 찾을 값을 입력해서 위치값 반환
		System.out.println("5. 특정 값의 위치 검색: " + idx);

		// 6. 배열 크기 변경
		int[] n5 = { 1, 2, 3 };
		n5 = Arrays.copyOf(n5, 5); // 입력한 크기만큼 변경, 늘어나면 기본값 입력됨
		System.out.println("6. 배열 크기 변경: " + Arrays.toString(n5)); // [1, 2, 3, 0, 0]

		// 7. 배열에서 스트림 생성
		int[] n6 = { 1, 2, 3 };
		System.out.println("7. 배열에서 스트림 생성");
		Arrays.stream(n6).forEach(System.out::println);

	}// end main
}// end class
