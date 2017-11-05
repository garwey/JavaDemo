import sort.NoncomparativeSort;

public class Test {
	public static void main(String[] args) {
		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 2, 2, 4, 9, 11, 10, 20, 30, 31 };
		NoncomparativeSort.bucketSort(arr, 4);

		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}

}
