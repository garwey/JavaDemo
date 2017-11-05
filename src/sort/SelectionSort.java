package sort;

public class SelectionSort {
	/**
	 * 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。<br/>
	 * 最差时间复杂度 ---- O(n^2)<br/>
	 * 最优时间复杂度 ---- O(n^2)<br/>
	 * 平均时间复杂度 ---- O(n^2)<br/>
	 * 空间复杂度 -------- O(1)<br/>
	 * 稳定性 ------------ 不稳定
	 * 
	 * @param arr
	 */
	public static void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j])
					min = j;
			}
			if (min != i) {
				swap(arr, min, i);
			}
		}
	}

	/**
	 * 堆排序利用了大根堆（或小根堆）堆顶记录的关键字最大（或最小）这一特征，使得在当前无序区中选取最大（或最小）关键字的记录变得简单。<br/>
	 * 过程：<br/>
	 * 1.由输入的无序数组构造一个最大堆，作为初始的无序区<br/>
	 * 2.把堆顶元素（最大值）和堆尾元素互换<br/>
	 * 3.把堆（无序区）的尺寸缩小1，并调用heapify(A, 0)从新的堆顶元素开始进行堆调整<br/>
	 * 4.重复步骤2，直到堆的尺寸为1<br/>
	 * 最差时间复杂度 ---- O(nlogn)<br/>
	 * 最优时间复杂度 ---- O(nlogn)<br/>
	 * 平均时间复杂度 ---- O(nlogn)<br/>
	 * 空间复杂度 -------- O(1)<br/>
	 * 稳定性 ------------ 不稳定
	 * 
	 * @param arr
	 */
	public static void heapSort(int arr[]) {
		int heapSize = arr.length;
		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			heapify(arr, i, heapSize);
		}
		while (heapSize > 1) {
			swap(arr, 0, --heapSize);
			heapify(arr, 0, heapSize);
		}
	}

	/**
	 * 从A[i]向下进行堆调整
	 */
	static void heapify(int arr[], int i, int size) {
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < size && arr[max] < arr[left])
			max = left;
		if (right < size && arr[max] < arr[right])
			max = right;
		if (max != i) {
			swap(arr, max, i);
			heapify(arr, left, size); // 递归调用，继续从当前结点向下进行堆调整
		}
	}

	static void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
