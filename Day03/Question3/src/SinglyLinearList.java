
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

	public void insert(int data) {
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
	}

	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	public void reverseDisplay() {
		reverseDisplay(head);
		System.out.println();
	}

	private void reverseDisplay(Node node) {
		if (node == null) {
			return;
		}
		reverseDisplay(node.next);
		System.out.print(node.data + " -> ");
	}

	public static void main(String[] args) {
		SinglyLinearList list = new SinglyLinearList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);

		System.out.println("List:");
		list.display();

		System.out.println("List in reverse order:");
		list.reverseDisplay();
	}
}
