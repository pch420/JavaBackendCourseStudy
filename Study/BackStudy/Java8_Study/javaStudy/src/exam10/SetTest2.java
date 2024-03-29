package exam10;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest2 {

	public static void main(String[] args) {

		// Set 계열 : 순서가 없고 중복 불가한 자료구조

		HashSet set = new HashSet();

		// 가정: 이름만 저장할 것이다.
		set.add("홍길동1");
		set.add("홍길동2");
		set.add("홍길동3");

		set.add(10);

		for (Object obj : set) { // 다형성
			String str = (String) obj;
			System.out.println(">>" + str.concat(" 님"));
		}
		/*
		 *  제네릭스를 안쓰면
		 *  1) 잘못된 데이터를 저장한 것을 실행시점에 알 수 있다.
		 *  2) 무조건 형변환이 필요하다.
		 *  
		 */

	}

}
