package exam03;

public class ArrayTest2 {

	public static void main(String[] args) {

		// 1. 1차원 배열 - new 이용

		// 가. 배열 선언

		String[] n2; // n2 : 변수, 참조형 변수, 로컬변수, String 타입의 배열

		// 나. 배열 생성
		n2 = new String[3];

		System.out.println(n2[0]); // int 값이므로 heap메모리에서 0으로 초기화
		System.out.println(n2[1]); // int 값이므로 heap메모리에서 00으로 초기화
		System.out.println(n2[2]); 

	}

}
