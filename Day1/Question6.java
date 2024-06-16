package Day01;

public class Question6 {

	public static int linearSearch(int[] arr, int occurance, int key) {
		int count = 0;
		for(int i = 0; i<arr.length; i++) {
			if(key == arr[i]){
				count++;
			}
			if(count==occurance) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] array = {1, 3, 7, 8, 7, 5, 6, 7, 2, 7, 10};
		int occurance = 4;
		int key = 10;
		int index = linearSearch(array, occurance, key);
		if(index != -1) {
			System.out.println("The "+occurance+"(st/nd/rd/th) occurance of "+key+" is found at "+index+" index.");
		}else {
			System.out.println("The "+occurance+"(st/nd/rd/th) occurance of "+key+" is not found. ");
		}
	}

}
//6. Implement linear search algorithm to find the nth occurence of the given element. If nth occurrence is not found, return -1.