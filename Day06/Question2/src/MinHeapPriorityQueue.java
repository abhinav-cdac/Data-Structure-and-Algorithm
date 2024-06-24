public class MinHeapPriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize an empty priority queue
    public MinHeapPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Function to return index of parent node
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Function to return index of left child node
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Function to return index of right child node
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Function to insert a new element into the priority queue
    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Priority Queue is full. Cannot insert.");
            return;
        }

        size++;
        int i = size - 1;
        heap[i] = element;

        // Maintain heap property by fixing upwards
        while (i != 0 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    // Function to remove and return the minimum element from the priority queue
    public int extractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE; // Return a large value indicating no element

        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);

        return root;
    }

    // Recursive function to heapify a subtree with the root at given index
    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size && heap[left] < heap[i])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }

    // Function to peek the minimum element in the priority queue
    public int peek() {
        if (size <= 0)
            return Integer.MAX_VALUE; // Return a large value indicating no element
        return heap[0];
    }

    // Function to check if the priority queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Function to print the elements of the priority queue
    public void printPriorityQueue() {
        System.out.print("Priority Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method to test priority queue using min heap
    public static void main(String[] args) {
        MinHeapPriorityQueue minHeapPQ = new MinHeapPriorityQueue(10);

        minHeapPQ.insert(3);
        minHeapPQ.insert(2);
        minHeapPQ.insert(15);
        minHeapPQ.insert(5);
        minHeapPQ.insert(4);
        minHeapPQ.insert(45);

        System.out.println("Priority Queue after insertion:");
        minHeapPQ.printPriorityQueue();

        System.out.println("Extracted min element: " + minHeapPQ.extractMin());

        System.out.println("Priority Queue after extraction:");
        minHeapPQ.printPriorityQueue();

        System.out.println("Min element in priority queue: " + minHeapPQ.peek());
    }
}
