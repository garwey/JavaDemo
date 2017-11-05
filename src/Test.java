import sort.NoncomparativeSort;

public class Test {
	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 2, 2, 4, 9, 11, 10 };
		NoncomparativeSort.bucketSort(arr);

		for (int i : arr) {
			System.out.println(i);
		}
	}

}
