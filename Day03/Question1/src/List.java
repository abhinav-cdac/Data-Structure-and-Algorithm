public class List {
    static class Node {
        private char data;
        private Node next;

        public Node(char value) {
            data = value;
            next = null;
        }
    }

    private Node tail;
    private int count;

    public List() {
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void addFirst(char value) {
        Node newnode = new Node(value);
        if (tail == null) {
            tail = newnode;
            newnode.next = newnode;
        } else {
            newnode.next = tail.next;
            tail.next = newnode;
        }
        count++;
    }

    public void addLast(char value) {
        Node newnode = new Node(value);
        if (tail == null) {
            tail = newnode;
            newnode.next = newnode;
        } else {
            newnode.next = tail.next;
            tail.next = newnode;
            tail = newnode;
        }
        count++;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node trav = tail.next;
        System.out.print("List: ");
        do {
            System.out.print(trav.data + " ");
            trav = trav.next;
        } while (trav != tail.next);
        System.out.println("\nNode count: " + count);
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        } else if (tail == tail.next) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        count--;
        System.out.println("First node deleted.");
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        } else if (tail == tail.next) {
            tail = null;
        } else {
            Node trav = tail.next;
            while (trav.next != tail) {
                trav = trav.next;
            }
            trav.next = tail.next;
            tail = trav;
        }
        count--;
        System.out.println("Last node deleted.");
    }

    public void addPosition(char value, int pos) {
        if (pos < 1 || pos > count + 1) {
            System.out.println("Invalid position.");
            return;
        }
        Node newnode = new Node(value);
        if (isEmpty()) {
            tail = newnode;
            newnode.next = newnode;
        } else if (pos == 1) {
            addFirst(value);
            return;
        } else {
            Node trav = tail.next;
            for (int i = 1; i < pos - 1; i++) {
                trav = trav.next;
            }
            newnode.next = trav.next;
            trav.next = newnode;
            if (trav == tail) {
                tail = newnode;
            }
        }
        count++;
        System.out.println("Value added at position " + pos + ".");
    }

    public void deletePosition(int pos) {
        if (pos < 1 || pos > count) {
            System.out.println("Invalid position.");
            return;
        }
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        } else if (pos == 1) {
            deleteFirst();
            return;
        } else {
            Node trav = tail.next;
            for (int i = 1; i < pos - 1; i++) {
                trav = trav.next;
            }
            trav.next = trav.next.next;
            if (trav.next == tail.next) {
                tail = trav;
            }
        }
        count--;
        System.out.println("Node at position " + pos + " deleted.");
    }

    public void deleteAll() {
        if (isEmpty()) {
            System.out.println("List is already empty.");
        } else {
            tail = null;
            count = 0;
            System.out.println("All nodes deleted.");
        }
    }
}
