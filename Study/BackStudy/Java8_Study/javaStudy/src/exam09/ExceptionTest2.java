package exam09;

class Test {
	public void a() {
		System.out.println("Test.a");
		// 연산 작업
		int num = 0;
		int result = 10 / num; // 예외 발생 ==> 비정상종료 됨.
		System.out.println("결과값:" + result);
	}
}

public class ExceptionTest2 {

	public static void main(String[] args) {
		// 정상종료
		System.out.println("1");
		System.out.println("2");

		Test t = new Test();
		t.a();

		System.out.println("end. 정상종료");

	}

}
