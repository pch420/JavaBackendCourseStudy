import java.util.PriorityQueue;

public class Algo03_선형구조_09_PriorityQueue {

	public static void main(String[] args) {

		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(20);
		q.add(10);
		q.add(40);
		q.add(50);
		q.add(6);

		System.out.println(q); // [6, 10, 40, 50, 20] 랜덤하게 저장됨. 따라서 정렬된 값을 확인 불가

		// 삭제될 때 정렬되서 삭제됨
		int n = q.size();
		for (int i = 0; i < n; i++) {
			System.out.println(q.poll());
		}

	}// end main
}// end class
