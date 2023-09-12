import java.util.Scanner;

/*-
	    0
	   / \
	  1   2
	 / \   \
	3   4   5
	
	입력 : 
	- 노드의 갯수 : 6
	- 노드  (-1은 빈공간)
	  0  1  2
	  1  3  4
	  2 -1  5
	  3 -1 -1
	  4 -1 -1
	  5 -1 -1
*/

public class Algo04_비선형구조01_tree01_배열02_순회 {

	static int n; // 노드 갯수
	static int[][] tree; // 노드 저장을 위한 2차원 배열

	public static void main(String[] args) {

		System.out.println("노드의 갯수 입력 : ");
		Scanner sc = new Scanner(System.in);

		// 노드 갯수 입력
		n = sc.nextInt();

		// 2차원 배열 생성
		tree = new int[n][2]; // [n][0]는 왼쪽 자식, [n][1]는 오른쪽 자식

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt(); // 부모노드
			int l_child = sc.nextInt(); // 자식왼쪽노드
			int r_child = sc.nextInt(); // 자식오른쪽노드
			tree[x][0] = l_child;
			tree[x][1] = r_child;
		}

		for (int i = 0; i < tree.length; i++) {
			for (int j = 0; j < tree[i].length; j++) {
				System.out.println(i + "값의 자식 : " + tree[i][j]);
			}
		}

		// 순회 : 재귀함수 이용 (왼쪽 자식 뿐만 아니라 오른쪽 자식 또한 트리가 되므로 재귀함수 사용함)
		order(0);

	}// end main

	// 순회
	private static void order(int x) {

		// 자식여부 확인
		if (tree[x][0] == -1 && tree[x][1] == -1) { // 자식이 없는 경우
			System.out.print(x + " ");
		} else { // 자식이 있는 경우
//			System.out.print("전위:" + x + " "); // root 왼 오, 0 1 3 4 2 5
			if (tree[x][0] != -1) { // 왼쪽 자식이 있는 경우
				order(tree[x][0]);
			}
//			System.out.print("중위: " + x + " "); // 왼 root 오, 3 1 4 0 2 5
			if (tree[x][1] != -1) { // 오른쪽 자식이 있는 경우
				order(tree[x][1]);
			}
			System.out.print("후위: " + x + " "); // 왼 오 root, 3 4 1 5 2 0

		}
	}

}// end class
