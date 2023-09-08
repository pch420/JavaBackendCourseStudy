import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Algo03_선형구조_06_TreeMap {

	public static void main(String[] args) {

		// TreeMap 생성 ( 기본적으로 key기준으로 오름차순 정렬됨 )
		// 대소문자 구별된 오름차순 정렬
		TreeMap<String, String> m = new TreeMap<>();
		m.put("A", "AAA");
		m.put("ab", "ab");
		m.put("B", "BBB");
		m.put("c++", "c++c++");
		m.put("d", "ddd");
		m.put("E", "EEE");

		// A:65 a:97 아스키코드값으로 정렬됨
		System.out.println(m); // {A=AAA, B=BBB, E=EEE, ab=ab, c++=c++c++, d=ddd}

		// 대소문자 구별된 내림차순 정렬
		TreeMap<String, String> m2 = new TreeMap<>(Comparator.reverseOrder());
		m2.put("A", "AAA");
		m2.put("ab", "ab");
		m2.put("B", "BBB");
		m2.put("c++", "c++c++");
		m2.put("d", "ddd");
		m2.put("E", "EEE");

		// A:65 a:97 아스키코드값으로 정렬됨
		System.out.println(m2); // {d=ddd, c++=c++c++, ab=ab, E=EEE, B=BBB, A=AAA}

		// 대소문자 구별하지 않은 오름차순 정렬
		// SortedMap을 TreeMap이 상속받아서 다형성 적용가능함
		SortedMap<String, String> m3 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		m3.put("A", "AAA");
		m3.put("ab", "ab");
		m3.put("B", "BBB");
		m3.put("c++", "c++c++");
		m3.put("d", "ddd");
		m3.put("E", "EEE");

		// A:65 a:97
		System.out.println(m3); // {A=AAA, ab=ab, B=BBB, c++=c++c++, d=ddd, E=EEE}

	}// end main
}// end class
