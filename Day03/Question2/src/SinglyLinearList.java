
public class SinglyLinearList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinearList() {
        this.head = null;
    }

    public void insertAfter(int after, int data) {
        Node newNode = new Node(data);
        Node current = head;

        while (current != null && current.data != after) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void insertBefore(int before, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return;
        }

        if (head.data == before) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != before) {
            current = current.next;
        }

        if (current.next != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void reverseDisplay(Node node) {
        if (node == null) {
            return;
        }
        reverseDisplay(node.next);
        System.out.print(node.data + " -> ");
    }

    public void reverseDisplay() {
        reverseDisplay(head);
        System.out.println("null");
    }

    public void insertInSortedOrder(int data) {
        Node newNode = new Node(data);

        if (head == null || head.data >= data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public static void main(String[] args) {
        SinglyLinearList list = new SinglyLinearList();
        list.insertInSortedOrder(10);
        list.insertInSortedOrder(5);
        list.insertInSortedOrder(20);
        list.insertInSortedOrder(15);
        System.out.println("List after inserting in sorted order:");
        list.display();

        list.insertAfter(10, 12);
        System.out.println("List after inserting 12 after 10:");
        list.display();

        list.insertBefore(20, 18);
        System.out.println("List after inserting 18 before 20:");
        list.display();

        System.out.println("List in reverse order:");
        list.reverseDisplay();
    }
}
