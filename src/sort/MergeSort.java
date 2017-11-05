package sort;

public class MergeSort {
	/**
	 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。<br/>
	 * 最差时间复杂度 ---- O(nlogn)br/> 最优时间复杂度 ---- O(nlogn)<br/>
	 * 平均时间复杂度 ---- O(nlogn)<br/>
	 * 空间复杂度 -------- O(n)<br/>
	 * 稳定性 ------------ 稳定
	 * 
	 * @param arr
	 */
	public static void mergeSortRecursion(int arr[], int left, int right) {
		if (left == right) // 当待排序的序列长度为1时，递归开始回溯，进行merge操作
			return;
		int mid = left + (right - left) / 2;
		mergeSortRecursion(arr, left, mid);
		mergeSortRecursion(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	// 归并的迭代算法
	public static void mergeSortIteration(int arr[]) {
		int left, mid, right;
		for (int i = 1; i < arr.length; i *= 2) {
			left = 0;
			while (left + i < arr.length) {
				mid = left + i - 1;
				right = mid + i < arr.length ? mid + i : arr.length - 1;
				merge(arr, left, mid, right);
				left = right + 1;
			}
		}
	}

	static void merge(int arr[], int left, int mid, int right) {
		int len = right - left + 1;
		int seq[] = new int[len];
		int i = left, j = mid + 1;
		int index = 0;
		while (i <= mid && j <= right) {
			seq[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
		}
		while (i <= mid) {
			seq[index++] = arr[i++];
		}
		while (j <= right) {
			seq[index++] = arr[j++];
		}
		for (int k = 0; k < len; k++)
			arr[left++] = seq[k];
	}

	static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
}
