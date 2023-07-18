package workshop4;

public class ArrayTest08 {

	public static void main(String[] args) {

		int[] score = { 99, 34, 67, 22, 11, 9 };
		int mx = score[0];
		int mn = score[0];

		for (int x : score) {
			if (mx <= x) {
				mx = x;
			}
			if (mn >= x) {
				mn = x;
			}
		}
		System.out.println("최대값:" + mx);
		System.out.println("최소값:" + mn);

	}

}
