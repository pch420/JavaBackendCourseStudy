import java.util.Arrays;

public class Algo05_정렬01_선택정렬_selection_sort {

	// 교환
	public static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

	// 정렬할 메서드
	public static void selection_sort(int[] arr, int size) {
		for (int i = 0; i < size - 1; i++) { // 마지막 회차는 반복할 필요 없음
			System.out.printf("%d 라운드:", i + 1);
			int minIdx = i;
			// 최소값 찾기
			for (int j = i + 1; j < size; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			} // end for
			System.out.print("교환 위치 및 값: " + (i+1) + ", " + arr[i]);
			System.out.println(" 최소값 : " + arr[minIdx]);
			// i 번째 값과 찾은 최소값(minIdx)을 서로 교환
			swap(arr, i, minIdx);
			System.out.println(Arrays.toString(arr));
		} // end for
	}// end selection_sort

	// 정렬할 데이터 저장
	static int[] arr = { 7, 3, 2, 8, 9, 4, 6, 1, 5 };

	public static void main(String[] args) {

		int size = arr.length;

		selection_sort(arr, size);

		// 정렬된 값 출력
		for (int x : arr) {
			System.out.print(x + " ");
		}

	}// end main

}// end class
