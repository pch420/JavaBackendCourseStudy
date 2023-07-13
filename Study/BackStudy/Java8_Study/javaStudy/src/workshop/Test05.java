package workshop;

public class Test05 {
	public static void main(String[] args) {

		int result = 0;
		while (true) {
			double r = Math.random() * 10;
			result = (int) r;

			if (result >= 1 && result <= 6) {
				break;
			}
		}
		System.out.println((int) result);

	}
}
