package sort;

public class InsertionSort {
	/**
	 * ÿ�δ��������ȡ����һ��Ԫ�أ��������뵽�����ĺ���λ�ã�ʹ�������Ȼ����<br/>
	 * ���ʱ�临�Ӷ� ---- ����Ϊ���������ǽ������е�,��ʱʱ�临�Ӷ�O(n^2)<br/>
	 * ����ʱ�临�Ӷ� ---- ������Ϊ�����������������е�,��ʱʱ�临�Ӷ�O(n)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(n^2)<br/>
	 * �ռ临�Ӷ� -------- O(1)<br/>
	 * �ȶ��� ------------ �ȶ�
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
	 * ���ڲ�����������Ƚϲ����Ĵ��۱Ƚ���������Ļ������Բ��ö��ֲ��ҷ������ٱȽϲ����Ĵ���<br/>
	 * ���ʱ�临�Ӷ� ---- O(n^2)<br/>
	 * ����ʱ�临�Ӷ� ---- O(nlogn)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- O(n^2)<br/>
	 * �ռ临�Ӷ� -------- O(1)<br/>
	 * �ȶ��� ------------ �ȶ�
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
	 * ϣ�������ǰѼ�¼���±��һ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨�������������𽥼��٣�ÿ������Ĺؼ���Խ��Խ�࣬����������1ʱ�������ļ�ǡ���ֳ�һ�飬�㷨����ֹ��<br/>
	 * ���ʱ�临�Ӷ� ---- ���ݲ������еĲ�ͬ����ͬ����֪��õ�ΪO(n(logn)^2)<br/>
	 * ����ʱ�临�Ӷ� ---- O(n)<br/>
	 * ƽ��ʱ�临�Ӷ� ---- ���ݲ������еĲ�ͬ����ͬ<br/>
	 * �ռ临�Ӷ� -------- O(1)<br/>
	 * �ȶ��� ------------ ���ȶ�
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
