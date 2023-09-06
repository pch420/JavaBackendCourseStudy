package exam01;

// 인터페이스
@FunctionalInterface // 추상메서드가 1개만 존재하도록 제한
interface Flyer {
	// 가. 파라미터 없고 리턴값 없음.
	public void fly();
}

public class LambdaTest {

	public static void main(String[] args) {

		// 익명 클래스
		/*-
		 * 인터페이스명 변수명 = new 인터페이스명(){
		 * 			// 추상 메서드 재정의
		 * };
		 */

		Flyer f = new Flyer() {

			@Override
			public void fly() {
				System.out.println("Flyer fly()");
			}
		};
		f.fly();

		// 람다 표현식
		Flyer f2 = () -> {
			System.out.println("람다 표현식 Flyer fly()");
		};
		f2.fly();
	}
}
