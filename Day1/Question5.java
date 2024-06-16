package Day01;

import java.util.Scanner;

public class Question5 {
	public static int binarySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length-1;
		while(start<=end) {
			int mid = start + (end - start)/2;
			if(key == arr[mid]) {
				return mid;
			}else if(key > arr[mid]){
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {90,80,70,60,50,40,30,20,10};
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Key element to be searched: ");
		int key = sc.nextInt();
		int index = binarySearch(arr,key);
		if(index !=-1) {
			System.out.println("Key element "+key+" found at "+index+" index");
		}else {
			System.out.println("Key element "+key+" not found");
		}
		sc.close();
	}

}


//Implement binary search algorithm if array is sorted in descending order.