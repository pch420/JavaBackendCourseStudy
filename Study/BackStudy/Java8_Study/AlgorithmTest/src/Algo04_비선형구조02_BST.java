import java.util.Scanner;

/*-
	   BST
	        35 
	     /      \ 
	    18      68
	  /    \      \
	 7     26     99
    / \   /  \
   3  12 22  30 	

	입력 : 
	10
	35 18 68
	18 7 26
	68 -1 99
	7 3 12
	26 22 30
	99 -1 -1
	3 -1 -1
	12 -1 -1
	22 -1 -1
	30 -1 -1
*/

public class Algo04_비선형구조02_BST {
	////////////////////////////////////////
	static class Node { // node 이름이 중복되면 중복클래스 에러가 뜨므로 static으로 만듬
		int data; // 노드값
		Node left; // 왼쪽 자식 노드 참조값
		Node right; // 오른쪽 자식 노드 참조값

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}

	} // end Node

	// Node 생성 메서드
	private static Node root;

	public static void createNode(int data, int leftData, int rightData) {

		// 초기상태 여부 확인
		if (root == null) { // 0 1 2
			root = new Node(data);

			if (leftData != -1) {
				root.left = new Node(leftData); // 왼쪽 자식 노드 생성
			}
			if (rightData != -1) {
				root.right = new Node(rightData); // 오른쪽 자식 노드 생성
			}
		} else {
			// 1 3 4
			// 루트노드 생성 이후에 만들어진 노드 중 어떤 것인지를 찾아야 된다.
			searchNode(root, data, leftData, rightData);
		}
	} // end createNode

	// 루트노드 생성 이후에 만들어진 노드 중 어떤 것인지를 찾아주는 메서드 : 재귀함수
	public static void searchNode(Node node, int data, int leftData, int rightData) {

		if (node == null) { // 찾을 노드가 없는 경우 메서드 종료
			return;
		} else if (node.data == data) { // 위치를 찾은 경우
			if (leftData != -1) {
				node.left = new Node(leftData); // 왼쪽 자식 노드 생성
			}
			if (rightData != -1) {
				node.right = new Node(rightData); // 오른쪽 자식 노드 생성
			}
		} else { // 찾지 못한 경우. 더 찾아야 됨.
			// 왼쪽 탐색
			searchNode(node.left, data, leftData, rightData);
			// 오른쪽 탐색
			searchNode(node.right, data, leftData, rightData);

		} // end if

	} // end searchNode

	public static void main(String[] args) {

		System.out.println("노드의 갯수 입력 : ");
		Scanner sc = new Scanner(System.in);

		// 노드 갯수 입력
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt(); // 부모노드
			int l_child = sc.nextInt(); // 자식왼쪽노드
			int r_child = sc.nextInt(); // 자식오른쪽노드

			createNode(x, l_child, r_child);

		} // end for

		// 생성된 연결리슽츠 출력
		System.out.println(root);

		// BST 검색
		Node searchNode = bstSearch(root, 18);
		if (searchNode != null) {
			System.out.println("탐색성공 " + num);
		} else {
			System.out.println("탐색실패 " + num);
		}

	}// end main

	// BST 트리용 검색 메서드
	static int num = 0;

	public static Node bstSearch(Node node, int key) {
		num++;
		if (node == null) {
			return null;
		}
		if (node.data == key) {
			return node;
		} else if (node.data < key) { // 현재 노드보다 찾을 값이 더 크면
			return bstSearch(node.right, key);
		} else {
			return bstSearch(node.left, key);
		}
	} // end bstSearch
}// end class
