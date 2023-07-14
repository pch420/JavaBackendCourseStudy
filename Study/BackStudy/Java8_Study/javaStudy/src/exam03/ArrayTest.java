package exam03;

public class ArrayTest {

	public static void main(String[] args) {

		// 1. 1차원 배열 - new 이용

		// 가. 배열 선언

		int[] n; // n : 변수, 참조형 변수, 로컬변수, int 타입의 배열
//		String[] n2; // n2 : 변수, 참조형 변수, 로컬변수, String 타입의 배열

		// 나. 배열 생성
		n = new int[2];
//		n2 = new String[3];

		System.out.println(n[0]); // int 값이므로 heap메모리에서 0으로 초기화
		System.out.println(n[1]); // int 값이므로 heap메모리에서 00으로 초기화
//		System.out.println(n[2]); // 없는 방 접근해서 ArrayIndexOutOfBoundsException 에러 발생

	}

}
