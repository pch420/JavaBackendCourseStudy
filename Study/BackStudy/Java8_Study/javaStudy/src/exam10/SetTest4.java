package exam10;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest4 {

	public static void main(String[] args) {

		// Set 계열 : 순서가 없고 중복 불가한 자료구조
		// 정수만 저장 ==> 컬렉션에서 참조형만 사용가능하기 때문에 Wrapper 클래스로 사용해야 함
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<>();

		set.add(10); // 오토박싱 : 기본형이 자동으로 참조형으로 변환됨
		set.add(20); // 오토박싱 : 기본형이 자동으로 참조형으로 변환됨
//		set.add("hello"); // 에러

		for (int i : set) { // 오토 언박싱
			System.out.println(i);

		}

		Iterator<Integer> ite = set.iterator();
		while (ite.hasNext()) {
			int num = ite.next();
			System.out.println("###" + num);
		}

	}

}
