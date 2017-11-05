package sort;

public class NoncomparativeSort {
	/**
	 * �������򣺶��ڸ��������������е�ÿһ��Ԫ��x��ȷ����������ֵС��x��Ԫ�صĸ�����<br/>
	 * ���ʱ�临�Ӷ� ---- O(n + k)<br/>
	 * ����ʱ�临�Ӷ� ---- O(n + k)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(n + k)<br/>
	 * �ռ临�Ӷ� -------- O(n + k)<br/>
	 * �ȶ��� ------------ �ȶ�
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
			c[i] += c[i - 1]; // c[i]����С�ڵ���i��Ԫ�ظ����������Ԫ��i�ͷ��ڵ�c[i]�����λ����
		}
		for (int i = 0; i < result.length; i++) {
			result[--c[arr[i] - min]] = arr[i];
		}
		for (int i = 0; i < result.length; i++) {
			arr[i] = result[i];
		}
	}

	/**
	 * �����д��Ƚ���ֵ����������ͳһΪͬ������λ���ȣ���λ�϶̵���ǰ�油�㡣Ȼ�󣬴����λ��ʼ�����ν���һ���������������λ����һֱ�����λ��������Ժ�,
	 * ���оͱ��һ���������С�<br/>
	 * ���ʱ�临�Ӷ� ---- O(n * dn)<br/>
	 * ����ʱ�临�Ӷ� ---- O(n * dn)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(n * dn)<br/>
	 * �ռ临�Ӷ� -------- O(n * dn)<br/>
	 * �ȶ��� ------------ �ȶ�
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
	 * ������Ԫ��ӳ�䵽����������Ͱ����ü���������Զ�λͰ�ı߽磬ÿ��Ͱ�ٸ��Խ���Ͱ������<br/>
	 * ���ʱ�临�Ӷ� ---- O(nlogn)��O(n^2)��ֻ��һ��Ͱ��ȡ����Ͱ������ʽ<br/>
	 * ����ʱ�临�Ӷ� ---- O(n)��ÿ��Ԫ��ռһ��Ͱ<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(n)����֤����Ͱ��Ԫ�ظ������ȼ���<br/>
	 * �ռ临�Ӷ� -------- O(n + bn)<br/>
	 * �ȶ��� ------------ �ȶ�
	 * 
	 * @param arr
	 */
	public static void bucketSort(int[] arr, int bucketNum) {
		int n = arr.length;
		int bn = bucketNum > n ? n : bucketNum; // Ͱ������
		int c[] = new int[bn];
		int min = arr[0], max = arr[0];
		for (int i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		int scale = (int) Math.ceil((double) (max - min) / bn); // Ͱ�����ݷ�Χ
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
