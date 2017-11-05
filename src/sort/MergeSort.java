package sort;

public class MergeSort {
	/**
	 * ��������������кϲ����õ���ȫ��������У�����ʹÿ��������������ʹ�����жμ������������������ϲ���һ���������Ϊ��·�鲢��<br/>
	 * ���ʱ�临�Ӷ� ---- O(nlogn)br/> ����ʱ�临�Ӷ� ---- O(nlogn)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(nlogn)<br/>
	 * �ռ临�Ӷ� -------- O(n)<br/>
	 * �ȶ��� ------------ �ȶ�
	 * 
	 * @param arr
	 */
	public static void mergeSortRecursion(int arr[], int left, int right) {
		if (left == right) // ������������г���Ϊ1ʱ���ݹ鿪ʼ���ݣ�����merge����
			return;
		int mid = left + (right - left) / 2;
		mergeSortRecursion(arr, left, mid);
		mergeSortRecursion(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	// �鲢�ĵ����㷨
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
