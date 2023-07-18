package workshop4;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();

		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 :");
		int i = sc.nextInt();
		int[] mx = new int[i];
		int temp = 0;

		for (int x = 0; x < mx.length; x++) {
			System.out.print("사람" + (x + 1) + ":");
			mx[x] = (int) (rnd.nextDouble() * 1000);
			System.out.println(mx[x]);
			if (temp <= mx[x]) {
				temp = mx[x];
			}
		}
		System.out.println("최댓값은 " + temp + "입니다.");

	}

}
