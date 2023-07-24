package exam10_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		// List 계열: 순서가 있고 중복이 가능

		ArrayList<String> list = new ArrayList<>();

		list.add("홍길동");
		list.add("이순신");
		list.add("유관순");
		list.add("홍길동");

		// 메서드 정리
		System.out.println("크기:" + list.size());

		// 수정
		list.set(1, "원균");

		// 삽입
		list.add(0, "강감찬");

		// 삭제
		list.remove(1); // 위치로 삭제
		list.remove("원균"); // 값으로 삭제 , 일치하는 첫번째 값만 삭제, 모두 삭제할려면 removeAll 사용

		// 부분리스트
		List<String> subList = list.subList(0, 2); // 0 ~ 1
		System.out.println(subList);

		// 출력방법1 - toString() 이용
		System.out.println(list);

	}

}
