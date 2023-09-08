
public class Algo01_팩토리얼 {

	// 점화식 : f(n) = n*f(n-1), f(1)=1
	private static int factorial(int n) {
		System.out.print(n + " ");
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {

		int x = factorial(5);
		System.out.print("= ");
		System.out.println(x);
	}// end main
}// end class
