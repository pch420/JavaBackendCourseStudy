import java.util.LinkedList;
import java.util.Queue;

/*-
	       1
	     /  \
	    2    3
	   / \    \
	  4   5    6
	 /          \
	7            8
	
	인접배열
      
        1 2 3 4 5 6 7 8
      1 0 1 1 0 0 0 0 0 
      2 1 0 0 1 1 0 0 0
      3 1 0 0 0 0 1 0 0 
      4 0 1 0 0 0 0 1 0
      5 0 1 0 0 0 0 0 0  
      6 0 0 1 0 0 0 0 1
      7 0 0 0 1 0 0 0 0
      8 0 0 0 0 0 1 0 0
	
	
*/
public class Algo04_비선형구조03_graph01_생성_인접행렬3_BFS {

	public static void main(String[] args) {

		int [] [] graph = {
				{},
				{2, 3},    // 1번 인덱스(1번 노드)의 이웃 지정
				{4, 5},   // 2번 인덱스(2번 노드)의 이웃 지정
				{6},      // 3번 인덱스(3번 노드)의 이웃 지정   
				{7},      // 4번 인덱스(4번 노드)의 이웃 지정
				{},       // 5번 인덱스(5번 노드)의 이웃 지정
				{8},      // 6번 인덱스(6번 노드)의 이웃 지정
				{},       // 7번 인덱스(7번 노드)의 이웃 지정
				{}        // 8번 인덱스(8번 노드)의 이웃 지정
		};

		// BFS

		// 방문 순서 저장용
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[9]; // 방문여부 확인, 기본값은 false

		q.offer(1); // 시작 정점 저장
		visited[1] = true; // 시작노드 방문처리

		// 스택에 값이 없으면 중단
		while (!q.isEmpty()) {

			int idx = q.poll();

			sb.append(idx + " -> "); // 방문 순서 저장

			// poll한 정점과 인접한 노드를 찾아서 offer
			for (int linkedNode : graph[idx]) {
				// 방문하지 않았을 경우에만 offer
				if (!visited[linkedNode]) {
					q.offer(linkedNode);
					visited[linkedNode] = true;
				}
			}

		} // end while

		System.out.println("BFS 순회:" + sb.toString());
		// BFS 순회:1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 

	}// end main

}// end class
