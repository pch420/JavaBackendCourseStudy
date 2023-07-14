package exam03;

public class ArrayTest6 {

	public static void main(String[] args) {

		// 1. 2차원 배열 출력

		// 가. 배열 선언
		int[][] n;

		// 나. 배열 생성
		n = new int[3][2];

		System.out.println("행의 길이:" + n.length);
		System.out.println("1행의 열길이:" + n[0].length);

		// 0 으로 자동 초기화
		System.out.println(n[0][0]);
		System.out.println(n[0][1]);

		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				System.out.println(">>" + n[i][j]);
			}
		}

		// 명시적 초기화
		n[0][0] = 1;
		n[0][1] = 2;
		n[1][0] = 3;
		n[1][1] = 4;
		n[2][0] = 5;
		n[2][1] = 6;

		// for each문
		for (int[] x : n) { // n에는 배열타입이 저장되어 있음
			for (int x2 : x) {
				System.out.println("$$" + x2);
			}
		}
	}

}
