public class HeapSortMinHeap {
    // Function to perform heap sort using min heap
    public void heapSort(int[] array) {
        int n = array.length;

        // Build min heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in array[]
    private void heapify(int[] array, int n, int i) {
        int smallest = i; // Initialize smallest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is smaller than root
        if (left < n && array[left] < array[smallest])
            smallest = left;

        // If right child is smaller than smallest so far
        if (right < n && array[right] < array[smallest])
            smallest = right;

        // If smallest is not root
        if (smallest != i) {
            int swap = array[i];
            array[i] = array[smallest];
            array[smallest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, smallest);
        }
    }

    // Function to print array elements
    public void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test heap sort
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        HeapSortMinHeap heapSort = new HeapSortMinHeap();

        System.out.println("Original array:");
        heapSort.printArray(array);

        heapSort.heapSort(array);

        System.out.println("Sorted array:");
        heapSort.printArray(array);
    }
}
