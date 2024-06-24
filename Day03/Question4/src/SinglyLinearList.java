
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

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SinglyLinearList list = new SinglyLinearList();
        list.insertInSortedOrder(30);
        list.insertInSortedOrder(10);
        list.insertInSortedOrder(20);
        list.insertInSortedOrder(40);

        System.out.println("List after inserting in sorted order:");
        list.display();
    }
}
