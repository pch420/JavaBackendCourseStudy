import java.util.Arrays;

public class Algo05_정렬02_삽입정렬_insertion_sort {

	// 교환
	public static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

	// 정렬할 메서드
	// 삽입정렬 : 현재 타겟일 되는 요소값과 이전 위치의 요소값을 비교해서 작으면 교환 (첫 번째 타켓은 2번째 부터 시작)
	public static void insertion_sort(int[] arr, int size) {

		// 2번째 시작
		for (int i = 1; i < size; i++) {
			System.out.printf("%d 라운드:", i);
			// 이전 요소와 비교하기 때문에 j-- 감소시킴
			for (int j = i; j > 0; j--) {
				System.out.print(" 타겟값 : " + arr[j]);
				if (arr[j - 1] > arr[j]) { // 이전 요소값보다 작으면 교환
					System.out.print(" 이전값 : " + arr[j - 1]);
					swap(arr, j - 1, j);
				} // end if
				System.out.println(Arrays.toString(arr));
			} // end for

		}
	}// end insertion_sort

	// 정렬할 데이터 저장
	static int[] arr = { 7, 3, 2, 8, 9, 4, 6, 1, 5 };

	public static void main(String[] args) {

		int size = arr.length;

		insertion_sort(arr, size);

		// 정렬된 값 출력
		for (int x : arr) {
			System.out.print(x + " "); // 1 2 3 4 5 6 7 8 9
		}

	}// end main

}// end class
