import java.util.Arrays;

public class InsertionSort {
    public static int insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                comparisons++;
            }
            arr[j + 1] = key;
            comparisons++;
        }
        return comparisons;
    }

    public static void main(String[] args) {
        int[] arr = {55, 44, 22, 66, 11, 33};
        int comparisons = insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.println("\nNumber of comparisons: " + comparisons);
    }
}
