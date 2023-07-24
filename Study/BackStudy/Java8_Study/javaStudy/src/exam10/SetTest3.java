package exam10;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest3 {

	public static void main(String[] args) {

		// Set 계열 : 순서가 없고 중복 불가한 자료구조
		// 앞에 제네릭스에는 타입이 필수, 뒤는 선택
		HashSet<String> set = new HashSet<String>();
		HashSet<String> set2 = new HashSet<>();

		// 가정: 이름만 저장할 것이다.
		set.add("홍길동1");
		set.add("홍길동2");
		set.add("홍길동3");

//		set.add(10);

		// 출력방법1 - toString()
		System.out.println(set);

		// 출력방법2 - foreach문 이용
		for (String obj : set) { // 다형성
//			String str = (String) obj;
			System.out.println(">>" + obj.concat(" 님"));
		}

		// 출력방법3 - Interator 이용
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String str = ite.next(); // 형변환이 필요없다.
			System.out.println("%%" + str);
		}

	}

}
