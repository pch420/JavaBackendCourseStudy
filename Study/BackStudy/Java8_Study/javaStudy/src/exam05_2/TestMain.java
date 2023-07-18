package exam05_2;

class Count {

	int n; // 인스턴스 변수, 객체생성할때마다 매번 생성
	static int m; // static 변수, 프로그램실행할 때 한번 생성, 이텔릭체, 자동초기화, 클래스명으로 접근

	public Count() {
		n++;
		m++;
	}

	public void n_print() { // 인스턴스 메서드
		System.out.println("n:" + n); // 인스턴스 변수 접근 가능
		System.out.println("m:" + m); // static 변수 접근 가능
	}

	public static void m_print() { // static 메서드
//		System.out.println("n:" + n); // 인스턴스 변수 접근 불가
//		System.out.println(this); // this 사용 불가 <= this는 인스턴스 이므로
		System.out.println("m:" + m); // static 변수 접근 가능

	}

} // end class

public class TestMain {

	public static void main(String[] args) {

		// new하기전에 static 접근 가능
		System.out.println(Count.m); // 0
		Count.m_print(); // new 하지않고 메서드 사용목적.

		// Count 객체생성을 몇번 했는지?
		Count c = new Count();
		c.n_print();
		Count c2 = new Count();
		c.n_print();

	}

}
