package exam01;

// 인터페이스
@FunctionalInterface // 추상메서드가 1개만 존재하도록 제한
interface Flyer3 {
	// 나. 파라미터 있고 리턴값 없음.
	public void fly(int n, int n2);
}

public class LambdaTest3 {

	public static void main(String[] args) {

		// 익명 클래스
		Flyer3 f = new Flyer3() {
			@Override
			public void fly(int n, int n2) {
				System.out.println("Flyer3 fly(int n, int n2)" + n + "\t" + n2);
			}

		};
		f.fly(10, 20);

		Flyer3 f2 = (int n, int n2) -> {
			System.out.println("람다표현식 Flyer3 fly(int n, int n2)" + n + "\t" + n2);
		};
		f2.fly(20, 30);

		Flyer3 f3 = (n, n2) -> {
			System.out.println("람다표현식 Flyer3 fly(int n, int n2)" + n + "\t" + n2);
		};
		f3.fly(30, 40);

	}// end main
}// end class
