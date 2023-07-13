package exam02;

public class IFTest4 {

	public static void main(String[] args) {

		// 4. switch 문
		// switch 인자값으로 byte, short, int, char, String, enum 인 6개만 사용 가능

		System.out.println("1");
		int num = 10;

		switch (num) {
		case 5:
			System.out.println("5");
			break;
		case 10:
			System.out.println("10");
			break;
		case 15:
			System.out.println("15");
			break;
		default:
			System.out.println("default");
		}

		char c = 'A';
		switch (c) {
		case 'A':
			System.out.println("A");
			break;
		case 'B':
			System.out.println("B");
			break;
		default:
			System.out.println("default");
		}

		String c2 = "A";
		switch (c2) {
		case "A":
			System.out.println("A");
			break;
		case "B":
			System.out.println("B");
			break;
		default:
			System.out.println("default");
		}

		System.out.println("end");

	}

}
