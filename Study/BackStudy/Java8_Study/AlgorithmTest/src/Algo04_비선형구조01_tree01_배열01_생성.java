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

public class Algo04_비선형구조01_tree01_배열01_생성 {

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

	}// end main
}// end class
