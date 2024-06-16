package Day01;

import java.util.Scanner;

public class Question3 {
	public static int linearSearch(int[] arr, int key) {
		int comparison = 0;
		for (int i = 0 ; i < arr.length; i++) {
			comparison++;
			if(key == arr[i]) {
				return comparison;
			}
		}
		return comparison;
	}
	public static int binarySearch(int[] arr, int key) {
		int comparison = 0;
		int start = 0;
		int end = arr.length-1;
		int mid;
		while(start <= end) {
			mid = start + (end - start)/2;
			comparison++;
			if (key == arr[mid]) {
				return comparison;
			}else if(key < arr[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return comparison;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,5,6,7,7,8};
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the key to be searched: ");
		int key = sc.nextInt();
		int comparison1 = linearSearch(arr,key);
	    System.out.println("No. of Comparison in Linear Search: "+ comparison1);
		int comparison2 = binarySearch(arr, key);
		System.out.println("No. of Comparison in Binary Search: "+ comparison2);
	}

}
// 3. Write a program to print no of comparisions done to search a key in i. linear search ii. binary search
/*
  i) linear search
   		1. take a key from user / decide the key
   		2. traverse the array from 0 to n-1
   		3. take comparison variable to count no. of comparison
   		3. compare the key with respective array elements
   		4. for every comparison increase comparison var by 1
   		5. return no. of comparison
  ii) binary search
        1. take a key from user / decide the key
        2. take a comparison variable to count no. of comparison
        2. calculate mid index mid = start + (end - start)/2
        3. compare the key with middle element
           -> if found then increase comparison by 1 and return it
        4. if not found then divide the array into two parts
           -> left subarray => end = mid - 1 
           -> right subarray => start = mid + 1
        5. repeat 3 & 4 step till array is valid or key element found
        6. invalid array:: start > end 
*/
