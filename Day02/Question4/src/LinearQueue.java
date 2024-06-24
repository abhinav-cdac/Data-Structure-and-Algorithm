class LinearQueue {
	private int[] arr;
	private int front;
	private int rear;
	private final int SIZE;

	public LinearQueue(int size) {
		// TODO Auto-generated method stub
		SIZE = size;
		arr = new int[SIZE];
		front = rear = 0;
	}

	public void push(int value) {
		if(!isFull()) {
			arr[rear] = value;
			rear++;
			System.out.println("Element added successfully.");
		}else {
			System.out.println("Queue is full.");
		}
		
	}

	public int pop() {
		if(!isEmpty()) {
			int value = arr[front];
			front++;
			return value;
		}else {
			System.out.println("Queue is empty.");
			return -1;
		}
		
	}

	public int peek() {
		if(!isEmpty()) {
			return arr[front];
		}else {
			return -1;
		}
		
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return rear == SIZE;
	}
}