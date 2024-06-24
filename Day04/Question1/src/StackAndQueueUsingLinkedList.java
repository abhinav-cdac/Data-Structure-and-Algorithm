
// LinkedList class with Node class nested inside
class LinkedList {
    // Static nested Node class
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
        
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	// Add node to the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println(data + " added to the beginning of the list.");
    }

    // Add node to the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println(data + " added to the end of the list.");
    }

    // Remove node from the beginning of the list
    public int removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int removedData = head.data;
        head = head.next;
        return removedData;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Display the elements of the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Stack class using LinkedList
class Stack {
    private LinkedList list;

    public Stack() {
        this.list = new LinkedList();
    }

    // Push operation
    public void push(int data) {
        list.addFirst(data); // Add to the beginning of the list (top of stack)
    }

    // Pop operation
    public int pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeFirst(); // Remove from the beginning of the list (top of stack)
    }

    // Peek operation
    public int peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getHead().getData(); // Peek at the top element without removing it
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Display the elements of the stack
    public void display() {
        list.display();
    }
}

// Queue class using LinkedList
class Queue {
    private LinkedList list;

    public Queue() {
        this.list = new LinkedList();
    }

    // Enqueue operation
    public void enqueue(int data) {
        list.addLast(data); // Add to the end of the list (rear of queue)
    }

    // Dequeue operation
    public int dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst(); // Remove from the beginning of the list (front of queue)
    }

    // Peek operation
    public int peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getHead().getData();  // Peek at the front element without removing it
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Display the elements of the queue
    public void display() {
        list.display();
    }
}

// Main class to demonstrate Stack and Queue using LinkedList
public class StackAndQueueUsingLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new Queue();

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.print("Stack: ");
        stack.display();

        // Popping element from stack
        System.out.println("Popped element: " + stack.pop());
        System.out.print("Stack after pop: ");
        stack.display();

        // Peeking element from stack
        System.out.println("Top element of stack: " + stack.peek());

        // Adding elements to the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.print("Queue: ");
        queue.display();

        // Removing element from queue
        System.out.println("Removed element: " + queue.dequeue());
        System.out.print("Queue after dequeue: ");
        queue.display();

        // Peeking element from queue
        System.out.println("Front element of queue: " + queue.peek());
    }
}
