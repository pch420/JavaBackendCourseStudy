import java.util.LinkedHashMap;

public class Algo03_선형구조_05_LinkedHashMap {

	public static void main(String[] args) {

		// LinkedHashMap 생성 ( 기본적으로 저장순서 유지됨 )
		// with predictable iteration order
		LinkedHashMap<String, String> m = new LinkedHashMap<String, String>();
		m.put("A", "AAA");
		m.put("B", "BBB");
		m.put("C", "CCC");

		// iterate
		// 1. m.forEach(Consumer)
		m.forEach((key, value) -> System.out.println(key + " = " + value));
		System.out.println();

		// 2. key값.forEach(Consumer)
		m.keySet().forEach(key -> System.out.println(key + " = " + m.get(key)));
		System.out.println();

	}// end main
}// end class
