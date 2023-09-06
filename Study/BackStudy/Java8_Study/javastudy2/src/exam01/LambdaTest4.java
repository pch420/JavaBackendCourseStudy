package exam01;

// 인터페이스
@FunctionalInterface // 추상메서드가 1개만 존재하도록 제한
interface Flyer4 {
	// 라. 파라미터 있고 리턴값 있음.
	public int fly(int n, int n2);
}

public class LambdaTest4 {

	public static void main(String[] args) {

		// 익명 클래스
		Flyer4 f = new Flyer4() {
			@Override
			public int fly(int n, int n2) {
				return n + n2;
			}

		};

		int result = f.fly(10, 20);
		System.out.println("result:" + result);

		// 람다 표현식
		Flyer4 f2 = (int n, int n2) -> {
			return n + n2;
		};

		Flyer4 f3 = (n, n2) -> {
			return n + n2;
		};

		// return 문장만 있으면 {}와 return 키워드 생략
		Flyer4 f4 = (n, n2) -> n + n2;
		int result4 = f.fly(10, 20);
		System.out.println("result4:" + result4);

	}// end main
}// end class
