package exam10_2;

import java.util.Date;

// 제네릭스 등장배경
class Box {
	Object obj;

	public void setValue(Object obj) {
		this.obj = obj;
	}

	public Object getValue() {
		return obj;
	}
}

public class GenericsTest {

	public static void main(String[] args) {

		// 문자열만 저장
		Box b1 = new Box();
		b1.setValue("홍길동");
//		b1.setValue(10); // 이슈1: 잘못된 데이터를 저장 할 수 있다. 실행시에 잘못된 데이터 저장했음을 안다.
		String str = (String) b1.getValue(); // 이슈2: 무조건 형변환해야 된다.
		System.out.println("문자열 길이:" + str.length());

		// 날찌만 저장
		Box b2 = new Box();
		b2.setValue(new Date());
//		b1.setValue(10); // 이슈1: 잘못된 데이터를 저장 할 수 있다. 실행시에 잘못된 데이터 저장했음을 안다.
		Date d = (Date) b2.getValue(); // 이슈2: 무조건 형변환해야 된다.
		System.out.println("날짜:" + d.getYear());

	}

}
