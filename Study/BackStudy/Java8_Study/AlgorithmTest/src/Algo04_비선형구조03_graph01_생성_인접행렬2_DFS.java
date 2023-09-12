import java.util.Stack;

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
public class Algo04_비선형구조03_graph01_생성_인접행렬2_DFS {

	public static void main(String[] args) {

		int [] [] graph = {
				{},
				{3, 2},    // 1번 인덱스(1번 노드)의 이웃 지정
				{5, 4},   // 2번 인덱스(2번 노드)의 이웃 지정
				{6},      // 3번 인덱스(3번 노드)의 이웃 지정   
				{7},      // 4번 인덱스(4번 노드)의 이웃 지정
				{},       // 5번 인덱스(5번 노드)의 이웃 지정
				{8},      // 6번 인덱스(6번 노드)의 이웃 지정
				{},       // 7번 인덱스(7번 노드)의 이웃 지정
				{}        // 8번 인덱스(8번 노드)의 이웃 지정
		};

		// DFS (깊이 우선 탐색)
		// 알고리즘 순서

		// 1. 스택 생성, boolean배열로 정점방문여부 확인
		// 2. 시작노드 저장 (1 저장), boolean값을 true
		// 3. pop 1
		// 4. pop 한 1과 연결된 정점을 저장(2, 3)

		// 방문 순서 저장용
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[9]; // 방문여부 확인, 기본값은 false

		stack.push(1); // 시작 정점 저장
		visited[1] = true; // 시작노드 방문처리

		// 스택에 값이 없으면 중단
		while (!stack.isEmpty()) {

			int idx = stack.pop();

			sb.append(idx + " -> "); // 방문 순서 저장

			// pop한 정점과 인접한 노드를 찾아서 push
			for (int linkedNode : graph[idx]) {
				// 방문하지 않았을 경우에만 push
				if (!visited[linkedNode]) {
					stack.push(linkedNode);
					visited[linkedNode] = true;
				}
			}

		} // end while

		System.out.println("DFS 순회:" + sb.toString());
		//DFS 순회:1 -> 3 -> 6 -> 8 -> 2 -> 5 -> 4 -> 7 -> 
		//DFS 순회:1 -> 2 -> 4 -> 7 -> 5 -> 3 -> 6 -> 8 -> 

	}// end main

}// end class
