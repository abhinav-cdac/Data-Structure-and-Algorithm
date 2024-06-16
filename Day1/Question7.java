package Day01;

public class Question7 {
	public static int firstNonRepeatingElement(int[] arr) {
		boolean isRepeating;
		for(int i = 0; i<arr.length; i++) {
			isRepeating = false;
			for(int j = 0; j<arr.length;j++) {
				if(i != j && arr[i]==arr[j]) {
					isRepeating = true;
					break;
				}
			}
			if(!isRepeating) {
				return arr[i];
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = { 1, 1,2};
		int element = firstNonRepeatingElement(arr);
		if (element!=-1) {
			System.out.println("First Non Repeating Element: "+element);
		}else {
			System.out.println("No Non Repeating Element is present");
		}
		
	}

}

/*
 * 7. find the first non-repeating element: Input: { 1, 2, 3, -1, 2, 1, 0, 4,-1, 7, 8 } Ouput: 3
 * 
1. use two for loops
   -> outer for iterating through each element
   -> inner for checking against every element
2. for every inner loop iteration initialize flag = false
3. if any repeating element found then set flag = true
4. after ending

 */
