package workshop;

public class Test02 {

	public static void main(String[] args) {

		// 조건 : 1부터 20까지의 정수 중에서 2의 배수가 아니고 3의 배수가 아닌 수의 총합을 구하시오.
		int sum = 0;
		for (int num = 1; num < 21; num++) {
			if (num % 2 != 0 && num % 3 != 0) {
				sum += num;
			}
		}
		System.out.println("sum = " + sum);

	}

}
