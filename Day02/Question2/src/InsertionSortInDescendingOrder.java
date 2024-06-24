import java.util.Arrays;

public class InsertionSortInDescendingOrder {
	public static void insertionSort(int[] arr) {
		int comparison = 0;
		for (int i = 1; i < arr.length; i++) {
			// 1. pick one element from the array (start with 2nd element)
			int temp = arr[i];
			// 2. compared picked ele with all its left neighbour(s) one by one
			int j = i - 1;
			while (j >= 0 && arr[j]<temp) {
				comparison++;
				arr[j+1] = arr [j];
				j--;
			}
			if(j>=0) {
				comparison++;
			}
			// 4. insert picked ele at its appropriate position
			arr[j + 1] = temp;
		}
		System.out.println("Comparison: " + comparison);
	}
	public static void main(String[] args) {
		int[] arr = { 55, 44, 22, 66, 11, 33 };
		System.out.println("Array before sorting: ");
		System.out.println("arr: " + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("Array after sorting: ");
		System.out.println("arr: " + Arrays.toString(arr));
	}

}