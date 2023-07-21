package exam08_1;

import java.util.Arrays;

public class StringBuilderTest {

	public static void main(String[] args) {

		// StringBuilder 클래스 이용한 문자열 생성 => 버퍼로 동작되기 때문에 자신의 문자열이 변경된다.
		StringBuilder sb = new StringBuilder("HeLLo"); // 권장
		StringBuffer sb2 = new StringBuffer("HeLLo");

		// 메서드
		System.out.println("1. 추가:" + sb.append("heelo"));
		System.out.println("1. 추가:" + sb.append(10));
		System.out.println("1. 추가:" + sb.append(3.14));

		System.out.println("2. 삽입:" + sb.insert(0, "홍길동"));
		System.out.println("2. 삽입:" + sb.insert(0, "100"));

		System.out.println("3. 삭제:" + sb.insert(0, 6)); // 0~5까지 삭제

		// charAt, substring, indexof, replace 지원
		System.out.println("4. 거꾸로:" + sb.reverse());

		System.out.println(sb);

		// 가장 마지막 작업은 String 로 저장해서 사용된다.
		String s = sb.toString();
		System.out.println("최종결과:" + s);
	}

}
