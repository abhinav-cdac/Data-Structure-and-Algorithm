import java.util.Scanner;

public class DequeUsingLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque deque = new Deque();
        int choice;

        do {
            System.out.println("\n---- Double Ended Queue (Deque) Operations ----");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at Rear");
            System.out.println("3. Delete from Front");
            System.out.println("4. Delete from Rear");
            System.out.println("5. Get Front Element");
            System.out.println("6. Get Rear Element");
            System.out.println("7. Get Size of Deque");
            System.out.println("8. Check if Deque is Empty");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at front: ");
                    int dataFront = sc.nextInt();
                    deque.insertFront(dataFront);
                    break;
                case 2:
                    System.out.print("Enter element to insert at rear: ");
                    int dataRear = sc.nextInt();
                    deque.insertRear(dataRear);
                    break;
                case 3:
                    int deletedFront = deque.deleteFront();
                    if (deletedFront != -1) {
                        System.out.println("Deleted element from front: " + deletedFront);
                    }
                    break;
                case 4:
                    int deletedRear = deque.deleteRear();
                    if (deletedRear != -1) {
                        System.out.println("Deleted element from rear: " + deletedRear);
                    }
                    break;
                case 5:
                    int front = deque.getFront();
                    if (front != -1) {
                        System.out.println("Front element: " + front);
                    }
                    break;
                case 6:
                    int rear = deque.getRear();
                    if (rear != -1) {
                        System.out.println("Rear element: " + rear);
                    }
                    break;
                case 7:
                    System.out.println("Size of Deque: " + deque.size());
                    break;
                case 8:
                    System.out.println("Deque is " + (deque.isEmpty() ? "empty" : "not empty"));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Deque {
    private Node head;
    private Node tail;
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertRear(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from front.");
            return -1; // or throw an exception
        }
        int deletedData = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return deletedData;
    }

    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from rear.");
            return -1; // or throw an exception
        }
        int deletedData = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return deletedData;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1; // or throw an exception
        }
        return head.data;
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1; // or throw an exception
        }
        return tail.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
