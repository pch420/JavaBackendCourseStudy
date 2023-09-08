import java.util.ArrayList;
import java.util.List;

public class Algo03_선형구조_02_ArrayList {

	public static void main(String[] args) {

		// ArrayList 생성

		List<Integer> x = new ArrayList<Integer>();
		x.add(3);
		x.add(13);
		x.add(23);

		System.out.println(x); // [3, 13, 23]

		List<Integer> x2 = new ArrayList<Integer>();
		x2.add(7);
		x2.add(6);
		x2.add(4);

		// ArrayList에 ArrayList 저장
		x.addAll(x2); // x에 x2 저장
		System.out.println(x); // [3, 13, 23, 7, 6, 4]

	}// end main
}// end class
