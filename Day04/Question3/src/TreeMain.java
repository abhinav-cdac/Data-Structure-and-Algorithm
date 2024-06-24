
public class TreeMain {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNodeNonRecursive(10);
		bst.add(20);
		bst.add(30);

		BinarySearchTree.Node temp = bst.findNonRec(20);
//		BinarySearchTree.Node temp1 = bst.find(40);
//		if (temp1 != null) {
//			System.out.println("Found: " + temp1.getData());
//		} else {
//			System.out.println("Not found");
//		}
		
//		BinarySearchTree.Node[] result = bst.searchWithParent(30);
//		
//		if(result[0] !=null && result[1]!=null) {
//			System.out.println("Key "+result[0].getData() +" found with "+result[1].getData()+" as parent");
//		}else {
//			System.out.println("Not Found");
//		}
	}

}

class BinarySearchTree {
	static class Node {
		private float data;
		private Node left;
		private Node right;

		public Node() {
			setData(0);
			left = null;
			right = null;
		}

		public Node(float val) {
			setData(val);
			left = null;
			right = null;
		}

		public float getData() {
			return data;
		}

		public void setData(float data) {
			this.data = data;
		}
	}

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	// Add Node
	public void addNodeNonRecursive(float value) {
		// 0. Create a node and initialize it
		Node newnode = new Node(value);

		// 1. if tree is empty, add new node to root
		if (root == null) {
			root = newnode;
			return;
		}
		// 2. if tree is not empty
		else {
			// create trav pointer and point it to root
			Node trav = root;
			while (true) {
				if (value < trav.getData()) {
					if (trav.left == null) {
						trav.left = newnode;
						break;
					} else {
						trav = trav.left;
					}
				} else { // value >= trav.data
					if (trav.right == null) {
						trav.right = newnode;
						break;
					} else {
						trav = trav.right;
					}

				}
			}

		}
	}

	// add node recursively
	public void add(float value) {
		if (root == null) {
			root = new Node(value);
		} else {
			add(root, value);
		}
	}

	public void add(Node trav, float value) {
		if (value < trav.getData()) {
			if (trav.left != null) {
				add(trav.left, value);
			} else {
				trav.left = new Node(value);
			}
		} else {
			if (trav.right != null) {
				add(trav.right, value);
			} else {
				trav.right = new Node(value);
			}
		}
	}

	// find/search node
	public Node findNonRec(float key) {
		Node trav = root;
		while (trav != null) {
			if (key == trav.getData()) {
				return trav;
			}
			if (key < trav.getData()) {
				trav = trav.left;
			} else {
				trav = trav.right;
			}
		}
		return null;
	}

	// find/search node recursively
	public Node find(float key) {
		return find(root, key);
	}

	public Node find(Node trav, float key) {
		Node temp;
		if (trav == null) {
			return null;
		} else if (key == trav.getData()) {
			return trav;
		} else if (key < trav.getData()) {
			temp = find(trav.left, key);
		} else {
			temp = find(trav.right, key);
		}
		return temp;
	}

	// find/search with parent
	public Node[] searchWithParent(float key) {
		Node trav = root;
		Node parent = null;

		while (trav != null) {
			if (trav.getData() == key) {
				return new Node[] { trav, parent };
			}

			parent = trav;
			if (key < trav.getData()) {
				trav = trav.left;
			} else {
				trav = trav.right;
			}
		}
		return new Node[] { null, null };
	}
}
