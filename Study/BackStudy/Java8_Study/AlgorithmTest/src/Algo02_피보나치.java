
public class Algo02_피보나치 {

	// 점화식 : f(n) = f(n-1) + f(n-2) , f(1)=f(2)=1
	private static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}// end main
}// end class
