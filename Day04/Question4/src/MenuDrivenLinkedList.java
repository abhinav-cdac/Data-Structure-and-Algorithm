
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List is empty");
        } else {
            Node current = head;
            System.out.print("Linked List: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void undo() {
        // Implement undo functionality to rollback last operation
        // For simplicity, assuming we only support adding nodes and undoing adds
        if (head == null) {
            System.out.println("Nothing to undo. Linked List is empty.");
        } else {
            Node current = head;
            Node prev = null;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            if (prev == null) {
                head = null; // Undo last add operation
            } else {
                prev.next = null; // Undo last add operation
            }
            size--;
            System.out.println("Last operation undone successfully.");
        }
    }
}

public class MenuDrivenLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int choice;
        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Add Node");
            System.out.println("2. Display");
            System.out.println("3. Undo");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to add: ");
                    int data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.undo();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
