package exam01;

// 인터페이스
@FunctionalInterface // 추상메서드가 1개만 존재하도록 제한
interface Flyer2 {
	// 나. 파라미터 있고 리턴값 없음.
	public void fly(int n);
}

public class LambdaTest2 {

	public static void main(String[] args) {

		// 익명 클래스
		Flyer2 f = new Flyer2() {
			@Override
			public void fly(int n) {
				System.out.println("Flyer2 fly(int n)" + n);
			}

		};
		f.fly(10);

		// 람다 표현식
		Flyer2 f2 = (int n) -> {
			System.out.println("람다 표현식 Flyer2 fly(int n)" + n);
		};
		f2.fly(20);

		// 데이터 타입 생략
		Flyer2 f3 = (n) -> {
			System.out.println("람다 표현식Flyer3 fly(int n)" + n);
		};
		f3.fly(30);

		// 매개변수가 하나면 () 생략
		Flyer2 f4 = n -> {
			System.out.println("람다 표현식Flyer4 fly(int n)" + n);
		};
		f4.fly(40);

	}// end main
}// end class
