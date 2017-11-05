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
	 * ��β������Ҳ���Ƕ���ð������.����ʱ����˫���������н�������<br/>
	 * ���ʱ�临�Ӷ� ---- O(n^2)<br/>
	 * ����ʱ�临�Ӷ� ---- ���������һ��ʼ�Ѿ��󲿷�������Ļ�,��ӽ�O(n)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(n^2)<br/>
	 * �ռ临�Ӷ� -------- O(1)<br/>
	 * �ȶ��� ------------ �ȶ�
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
	 * ʹ�÷��β���(Divide and Conquer)����һ�����з�Ϊ���������С�<br/>
	 * ���̣�<br/>
	 * 1.������������һ��Ԫ�أ���Ϊ"��׼"(pivot).<br/>
	 * 2.�����бȻ�׼ֵС��Ԫ�ط��ڻ�׼ǰ�棬���бȻ�׼ֵ���Ԫ�ط��ڻ�׼�ĺ��棨��ͬ�������Ե���һ�ߣ��������Ϊ����(partition)������<br/>
	 * 3.��ÿ�������ݹ�ؽ��в���1~2���ݹ�Ľ������������еĴ�С��0��1����ʱ�����Ѿ����ź����ˡ�<br/>
	 * ���ʱ�临�Ӷ� ----
	 * ÿ��ѡȡ�Ļ�׼������󣨻���С����Ԫ�أ�����ÿ��ֻ���ֳ���һ����������Ҫ����n-1�λ��ֲ��ܽ����ݹ飬ʱ�临�Ӷ�ΪO(n^2)<br/>
	 * ����ʱ�临�Ӷ� ----
	 * ÿ��ѡȡ�Ļ�׼������λ��������ÿ�ζ����ȵĻ��ֳ�����������ֻ��Ҫlogn�λ��־��ܽ����ݹ飬ʱ�临�Ӷ�ΪO(nlogn)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(nlogn)<br/>
	 * �ռ临�Ӷ� -------- ��Ҫ�ǵݹ���ɵ�ջ�ռ��ʹ��(��������left��right�Ⱦֲ�����)��ȡ���ڵݹ�������ȣ�һ��ΪO(logn)�����ΪO(n)<br/>
	 * �ȶ��� ------------ ���ȶ�
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
			while (j > i && arr[j] >= pivot) // �˴�һ��ҪС�ڵ���
				j--;
			arr[i] = arr[j];
			while (i < j && arr[i] <= pivot) // �˴�һ��ҪС�ڵ���
				i++;
			arr[j] = arr[i];
		}
		arr[i] = pivot; // ���
		qSort(arr, low, i - 1);
		qSort(arr, i + 1, high);
	}

	static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
