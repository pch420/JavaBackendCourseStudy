package exam02;

public class VariableTest {

	int n2; // 인스턴스 변수, 0으로 자동 초기화
	static int n3; // 클래스 변수(static 변수), 0으로 자동초기화

	// main 메서드
	public static void main(String[] args) {

		int n; // 로컬변수, 자동 초기화 안됨. 반드시 사용전에 초기화해야 한다.
		n = 0;
		System.out.println(n);

	}

}
