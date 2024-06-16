package Day01;

import java.util.Arrays;

public class Question9 {

	public static int selectionSort(int[] arr){
		int comparison = 0;
		for(int i = 0; i<arr.length;i++) {
			for (int j = i + 1; j<arr.length; j++) {
				comparison++;
				if (arr[i]<=arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return comparison;
	}
	public static void main(String[] args) {
		int[] arr = {88, 33, 66, 99, 11,11, 77, 22, 55, 14};
		System.out.println("Array before sorting: "+Arrays.toString(arr));
		int comparison = selectionSort(arr);
		System.out.println("Array after sorting: "+Arrays.toString(arr));
		System.out.println("The number of comparison: "+comparison);
	}

}

//9. Write a selection sort function to sort array and returns no of comparisons.
// formula for no. of comparison in selection sort = n(n-1)/2 where n = array size
