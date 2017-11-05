package sort;

public class SelectionSort {
	/**
	 * ÿһ�δӴ����������Ԫ����ѡ����С������󣩵�һ��Ԫ�أ���������е���ʼλ�ã�ֱ��ȫ�������������Ԫ�����ꡣ<br/>
	 * ���ʱ�临�Ӷ� ---- O(n^2)<br/>
	 * ����ʱ�临�Ӷ� ---- O(n^2)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(n^2)<br/>
	 * �ռ临�Ӷ� -------- O(1)<br/>
	 * �ȶ��� ------------ ���ȶ�
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
	 * �����������˴���ѣ���С���ѣ��Ѷ���¼�Ĺؼ�����󣨻���С����һ������ʹ���ڵ�ǰ��������ѡȡ��󣨻���С���ؼ��ֵļ�¼��ü򵥡�<br/>
	 * ���̣�<br/>
	 * 1.��������������鹹��һ�����ѣ���Ϊ��ʼ��������<br/>
	 * 2.�ѶѶ�Ԫ�أ����ֵ���Ͷ�βԪ�ػ���<br/>
	 * 3.�Ѷѣ����������ĳߴ���С1��������heapify(A, 0)���µĶѶ�Ԫ�ؿ�ʼ���жѵ���<br/>
	 * 4.�ظ�����2��ֱ���ѵĳߴ�Ϊ1<br/>
	 * ���ʱ�临�Ӷ� ---- O(nlogn)<br/>
	 * ����ʱ�临�Ӷ� ---- O(nlogn)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(nlogn)<br/>
	 * �ռ临�Ӷ� -------- O(1)<br/>
	 * �ȶ��� ------------ ���ȶ�
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
	 * ��A[i]���½��жѵ���
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
			heapify(arr, left, size); // �ݹ���ã������ӵ�ǰ������½��жѵ���
		}
	}

	static void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
