package sort;

public class SwapSort {
	public static void bubbleSort(int[] arr) {
		int l = arr.length;
		for (int i = 0; i < l - 1; i++) {
			for (int j = 0; j < l - i - 1; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	/**
	 * 鸡尾酒排序也就是定向冒泡排序.排序时是以双向在序列中进行排序。<br/>
	 * 最差时间复杂度 ---- O(n^2)<br/>
	 * 最优时间复杂度 ---- 如果序列在一开始已经大部分排序过的话,会接近O(n)<br/>
	 * 平均时间复杂度 ---- O(n^2)<br/>
	 * 空间复杂度 -------- O(1)<br/>
	 * 稳定性 ------------ 稳定
	 * 
	 * @param arr
	 */
	public static void cocktailSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			for (int i = left; i < right; i++) {
				if (arr[i] > arr[i + 1])
					swap(arr, i, i + 1);
			}
			right--;
			for (int i = right; i > left; i--) {
				if (arr[i - 1] > arr[i])
					swap(arr, i - 1, i);
			}
			left++;
		}
	}

	/**
	 * 使用分治策略(Divide and Conquer)来把一个序列分为两个子序列。<br/>
	 * 过程：<br/>
	 * 1.从序列中挑出一个元素，作为"基准"(pivot).<br/>
	 * 2.把所有比基准值小的元素放在基准前面，所有比基准值大的元素放在基准的后面（相同的数可以到任一边），这个称为分区(partition)操作。<br/>
	 * 3.对每个分区递归地进行步骤1~2，递归的结束条件是序列的大小是0或1，这时整体已经被排好序了。<br/>
	 * 最差时间复杂度 ----
	 * 每次选取的基准都是最大（或最小）的元素，导致每次只划分出了一个分区，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)<br/>
	 * 最优时间复杂度 ----
	 * 每次选取的基准都是中位数，这样每次都均匀的划分出两个分区，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)<br/>
	 * 平均时间复杂度 ---- O(nlogn)<br/>
	 * 空间复杂度 -------- 主要是递归造成的栈空间的使用(用来保存left和right等局部变量)，取决于递归树的深度，一般为O(logn)，最差为O(n)<br/>
	 * 稳定性 ------------ 不稳定
	 * 
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		qSort(arr, 0, arr.length - 1);
	}

	static void qSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int pivot = arr[low];
		int i = low, j = high;
		while (i < j) {
			while (j > i && arr[j] >= pivot) // 此处一定要小于等于
				j--;
			arr[i] = arr[j];
			while (i < j && arr[i] <= pivot) // 此处一定要小于等于
				i++;
			arr[j] = arr[i];
		}
		arr[i] = pivot; // 填坑
		qSort(arr, low, i - 1);
		qSort(arr, i + 1, high);
	}

	static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
