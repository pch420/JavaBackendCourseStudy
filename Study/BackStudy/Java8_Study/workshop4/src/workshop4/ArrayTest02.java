package workshop4;

public class ArrayTest02 {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int sum = 0;

		for (int x = 0; x < arr.length; x++) {
			if ((x + 1) % 2 == 0) {
				sum += arr[x];
			}
		}

		System.out.println("sum=" + sum);

	}

}
