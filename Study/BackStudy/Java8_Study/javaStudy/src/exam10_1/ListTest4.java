package exam10_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest4 {

	public static void main(String[] args) {

		// List 계열: 순서가 있고 중복이 가능

		List<String> list = new ArrayList<>(); // 다형성 (매우 중요)

		list.add("홍길동");
		list.add("이순신");
		list.add("유관순");
		list.add("홍길동");

		// 홍길동 삭제
//		list.remove("홍길동"); // 첫번째 일치하는 값만 삭제됨.
		list.removeAll(Arrays.asList("홍길동")); // list.removeAll(Collection), 일치하는 값 다 삭제

		System.out.println(list);

	}

}
