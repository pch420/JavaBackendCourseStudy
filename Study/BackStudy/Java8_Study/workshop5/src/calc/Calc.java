package calc;

public class Calc {

	public int calculate(int data) {
		int calculate = 0;

		for (int x = 1; x <= data; x++) {
			if (x % 2 == 0) {
				calculate += x;
			}
		}

		return calculate;
	}

}
