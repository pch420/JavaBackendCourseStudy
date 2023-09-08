
public class Algo02_피보나치2_DP {

	// 점화식 : f(n) = f(n-1) + f(n-2) , f(1)=f(2)=1
	/*
	 * DP (Dynamic Programming) - 메모이제이션(memoization)을 활용하여 동일한 계산이 반복될 때 재사용하여
	 * 프로그램의 성능을 향상
	 */

	// 단순재귀
	static int num = 0;

	private static int fibonacci2(int n) {
		num++;
		if (n <= 1) {
			return n;
		} else {
			return fibonacci2(n - 1) + fibonacci2(n - 2);
		}
	}

	// DP로 구현
	static int[] dp;

	private static int fibonacci(int n) {
		num++;
		if (n <= 1) {
			return n;
		} else {
			if (dp[n] != 0) {
				return dp[n];
			}
			dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
			return dp[n];
		}
	}

	public static void main(String[] args) {
		dp = new int[11];
		for (int i = 1; i <= 10; i++) {
			System.out.print(fibonacci2(i) + " ");
		}
		System.out.println("num: " + num); // DP : 28번, 일반재귀 : 452번
	}// end main
}// end class
