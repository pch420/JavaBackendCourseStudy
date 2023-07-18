package calc;

public class TestCalc {

	public static void main(String[] args) {
		int data = Integer.parseInt(args[0]);
		Calc c = new Calc();

		if (data > 10 || data < 5) {
			System.out.println("다시 입력하세요");
		} else {
			System.out.println("결과: " + c.calculate(data));
		}
	}

}
