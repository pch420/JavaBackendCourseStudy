import java.util.ArrayList;
import java.util.List;

public class Algo03_선형구조_02_ArrayList2_삭제 {

	public static void main(String[] args) {

		// ArrayList 삭제
		List<String> x = new ArrayList<String>();
		x.add("C");
		x.add("C++");
		x.add("Java");
		x.add("Kotlin");
		x.add("Python");
		x.add("SQL");

		String str = x.remove(5); // idx 이용한 삭제, 삭제한 값 반환
		System.out.println(str); // SQL

		boolean b = x.remove("Kotlin"); // 값 이용한 삭제, boolean 반환
		System.out.println(b); // true

		x.removeIf(t -> t.startsWith("C")); // C로 시작되는 값 삭제
		System.out.println(x); // [Java, Python]

		// 삭제할 값을 List에 저장하고 이 List값을 이용해서 삭제
		List<String> x2 = new ArrayList<String>();
		x2.add("Java");

		x.removeAll(x2); // 삭제할 값이 든 collection 입력
		System.out.println(x); // [Python]

	}// end main
}// end class
