package workshop4;

import java.util.Random;

public class ArrayTest10 {

	public static void main(String[] args) {

		if (args.length > 2 || args.length < 2) {
			System.out.println("다시 입력 하세요");
			return;
		}

		int row = Integer.parseInt(args[0]);
		int col = Integer.parseInt(args[1]);

		if ((row > 5 || row < 1) || (col > 5 || col < 1)) {
			System.out.println("숫자를 확인하세요");
			return;
		}

		int[][] arr = new int[row][col];
		Random rand = new Random();
		double sum = 0;
		int count = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = rand.nextInt(5) + 1;
				sum += arr[i][j];
				count++;
				System.out.print(arr[i][j] + " ");
			}

		}
		System.out.println();
		System.out.println("sum=" + sum);
		System.out.println("avg=" + (sum / count));

	}
}
