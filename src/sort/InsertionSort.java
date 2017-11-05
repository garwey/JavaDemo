package sort;

public class InsertionSort {
	/**
	 * 每次从无序表中取出第一个元素，把它插入到有序表的合适位置，使有序表仍然有序。<br/>
	 * 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)<br/>
	 * 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)<br/>
	 * 平均时间复杂度 ---- O(n^2)<br/>
	 * 空间复杂度 -------- O(1)<br/>
	 * 稳定性 ------------ 稳定
	 * 
	 * @param arr
	 */
	public static void straightInsertSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int temp = arr[i];
			while (j >= 0 && temp < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	/**
	 * 对于插入排序，如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的次数<br/>
	 * 最差时间复杂度 ---- O(n^2)<br/>
	 * 最优时间复杂度 ---- O(nlogn)<br/>
	 * 平均时间复杂度 ---- O(n^2)<br/>
	 * 空间复杂度 -------- O(1)<br/>
	 * 稳定性 ------------ 稳定
	 * 
	 * @param arr
	 */
	public static void binarySort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (temp < arr[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
			for (int j = i; j > left; j--) {
				arr[j] = arr[j - 1];
			}
			arr[left] = temp;
		}
	}

	/**
	 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。<br/>
	 * 最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)<br/>
	 * 最优时间复杂度 ---- O(n)<br/>
	 * 平均时间复杂度 ---- 根据步长序列的不同而不同<br/>
	 * 空间复杂度 -------- O(1)<br/>
	 * 稳定性 ------------ 不稳定
	 * 
	 * @param arr
	 */
	public static void shellSort(int arr[]) {
		int d = arr.length;
		while (true) {
			d /= 2;
			for (int i = d; i < arr.length; i++) {
				int temp = arr[i];
				int j = i - d;
				while (j >= 0 && temp < arr[j]) {
					arr[j + d] = arr[j];
					j -= d;
				}
				arr[j + d] = temp;
			}
			if (d == 1)
				break;
		}
	}
}
