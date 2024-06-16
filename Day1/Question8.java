package Day01;

public class Question8 {
	public static int rankOfElement(int[] arr, int key) {
		int rank = 0;
		for (int arr1 : arr) {
			if (arr1<= key) {
				rank++;
			}
		}
		return rank;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 15, 3, 4, 4, 1 };
		int key = 20;
		int rank = rankOfElement(arr, key);
		System.out.println("Rank of " + key + " is " + rank);
	}

}

/*
 * 8. to find rank of an element in a stream of integers. rank: rank of a given
 * integer "x", in stream is "total no. of ele's less than or equal to x
 * (including x). Input: { 10, 20, 15, 3, 4, 4, 1 } Ouput: Rank of 4 is: 4
 * 
 * we have to find how many element in the given array is less than or equal to
 * the key element for eg.: 1 => rank = 1; eg.: 3 => rank = 2; 1 & 3 eg.: 10 =>
 * rank = 5 1,3,4,4 & 10 eg.: 15 => rank = 6; 1,3,4,4,10 & 15
 *
 * 
 */
