package sort;

public class NoncomparativeSort {
	/**
	 * 计数排序：对于给定的输入序列中的每一个元素x，确定该序列中值小于x的元素的个数。<br/>
	 * 最差时间复杂度 ---- O(n + k)<br/>
	 * 最优时间复杂度 ---- O(n + k)<br/>
	 * 平均时间复杂度 ---- O(n + k)<br/>
	 * 空间复杂度 -------- O(n + k)<br/>
	 * 稳定性 ------------ 稳定
	 * 
	 * @param arr
	 */
	public static void countingSort(int[] arr) {
		int result[] = new int[arr.length];
		int max = arr[0], min = arr[0];
		for (int i : arr) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}
		int len = max - min + 1;
		int c[] = new int[len];
		for (int i = 0; i < arr.length; i++) {
			c[arr[i] - min]++;
		}
		for (int i = 1; i < len; i++) {
			c[i] += c[i - 1]; // c[i]保存小于等于i的元素个数，排序后元素i就放在第c[i]个输出位置上
		}
		for (int i = 0; i < result.length; i++) {
			result[--c[arr[i] - min]] = arr[i];
		}
		for (int i = 0; i < result.length; i++) {
			arr[i] = result[i];
		}
	}

	/**
	 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,
	 * 数列就变成一个有序序列。<br/>
	 * 最差时间复杂度 ---- O(n * dn)<br/>
	 * 最优时间复杂度 ---- O(n * dn)<br/>
	 * 平均时间复杂度 ---- O(n * dn)<br/>
	 * 空间复杂度 -------- O(n * dn)<br/>
	 * 稳定性 ------------ 稳定
	 * 
	 * @param arr
	 */
	public static void radixSort(int[] arr) {
		int n = arr.length;
		int d = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		while (max > 0) {
			d++;
			max /= 10;
		}
		for (int i = 1; i <= d; i++) {
			for (int j = 0; j < n; j++) {
				int min = j;
				for (int k = j + 1; k < n; k++) {
					int a = arr[k] % (int) Math.pow(10, i) - arr[k] % (int) Math.pow(10, (i - 1));
					int b = arr[min] % (int) Math.pow(10, i) - arr[min] % (int) Math.pow(10, (i - 1));
					if (a < b)
						min = k;
				}
				swap(arr, min, j);
			}
		}
	}

	/**
	 * 将数组元素映射到有限数量个桶里，利用计数排序可以定位桶的边界，每个桶再各自进行桶内排序<br/>
	 * 最差时间复杂度 ---- O(nlogn)或O(n^2)，只有一个桶，取决于桶内排序方式<br/>
	 * 最优时间复杂度 ---- O(n)，每个元素占一个桶<br/>
	 * 平均时间复杂度 ---- O(n)，保证各个桶内元素个数均匀即可<br/>
	 * 空间复杂度 -------- O(n + bn)<br/>
	 * 稳定性 ------------ 稳定
	 * 
	 * @param arr
	 */
	public static void bucketSort(int[] arr, int bucketNum) {
		int n = arr.length;
		int bn = bucketNum > n ? n : bucketNum; // 桶的数量
		int c[] = new int[bn];
		int min = arr[0], max = arr[0];
		for (int i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		int scale = (int) Math.ceil((double) (max - min) / bn); // 桶的数据范围
		scale = scale > n ? n : scale;
		for (int i = 0; i < n; i++) {
			int index = (arr[i] - min) / scale;
			c[index < bn ? index : bn - 1]++;
		}
		int bucket[][] = new int[bn][];
		for (int i = 0; i < bn; i++) {
			bucket[i] = new int[c[i]];
		}
		for (int i = 0; i < n; i++) {
			int index = (arr[i] - min) / scale;
			index = index < bn ? index : bn - 1;
			bucket[index][--c[index]] = arr[i];
		}
		for (int i = 0; i < bn; i++) {
			InsertionSort.straightInsertSort(bucket[i]);
		}
		int index = 0;
		for (int i = 0; i < bn; i++) {
			for (int j = 0; j < bucket[i].length; j++)
				arr[index++] = bucket[i][j];
		}

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
