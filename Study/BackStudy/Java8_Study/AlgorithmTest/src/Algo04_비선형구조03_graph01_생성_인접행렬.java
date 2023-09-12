import java.util.Scanner;

/*-
	생성 : 인접행렬(2차원 배열)
	
	  1 2 3 4 5
	1 0 1 1 0 0
	2 1 0 0 0 1
	3 1 0 0 1 0
	4 0 0 1 0 1
	5 0 1 0 1 0
	
	입력 :
	5 5 	정점개수  간선개수
	5 4 	연결된 정점 지정 5와 4가 연결됨
	5 2 	연결된 정점 지정 5와 2가 연결됨
	1 2		연결된 정점 지정 1와 2가 연결됨
	3 4		연결된 정점 지정 3와 4가 연결됨
	3 1		연결된 정점 지정 3와 1가 연결됨
	
	5 5
	5 4
	5 2
	1 2
	3 4
	3 1
	
*/
public class Algo04_비선형구조03_graph01_생성_인접행렬 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정점의 갯수
		int m = sc.nextInt(); // 간선의 갯수

		// 인접행렬(2차원 배열)
		int[][] adjArray = new int[n+1][n+1]; // 요소접근은 1부터 하기 위하여

		// 간선의 갯수만큼 반복해서 인접행렬에 저장
		for (int i = 0; i < m; i++) {
			// 연결된 정점 지정
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			// 무방향이기 때문에 양쪽(큰수-작은수, 작은수-큰수) 다 표현
			adjArray[v1][v2] = 1;
			adjArray[v2][v1] = 1;
		}

		// 인접행렬 출력
		System.out.println("  1 2 3 4 5");
		for (int i = 1; i < adjArray.length; i++) {
			System.out.print(i + " ");
			for (int j = 1; j < adjArray[i].length; j++) {
				System.out.print(adjArray[i][j] + " ");
			}
			System.out.println();
		}
	}// end main

}// end class
