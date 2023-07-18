package workshop4;

import java.util.Random;

public class ArrayTest09 {

	public static void main(String[] args) {

		int[] arr3 = new int[5];
		Random rand = new Random();
		int sum = 0;

		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = rand.nextInt(11);
			sum += arr3[i];
			System.out.print(arr3[i] + " ");
		}
		System.out.println();
		System.out.println("sum=" + sum);
		System.out.println("avg=" + (double) sum / arr3.length);

	}

}
