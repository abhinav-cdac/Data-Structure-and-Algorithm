public class BSTLeafNodesCount {
    // Node class representing a node in BST
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BSTLeafNodesCount() {
        root = null;
    }

    // Function to insert a node into BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    // Function to perform inorder traversal of BST
    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderTraversalRec(root);
        System.out.println();
    }

    private void inorderTraversalRec(Node root) {
        if (root != null) {
            inorderTraversalRec(root.left);
            System.out.print(root.data + " ");
            inorderTraversalRec(root.right);
        }
    }

    // Function to count the number of leaf nodes in BST
    public int countLeafNodes() {
        return countLeafNodesRec(root);
    }

    private int countLeafNodesRec(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        else
            return countLeafNodesRec(root.left) + countLeafNodesRec(root.right);
    }

    // Main method to test counting leaf nodes
    public static void main(String[] args) {
        BSTLeafNodesCount bst = new BSTLeafNodesCount();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.inorderTraversal();

        int leafCount = bst.countLeafNodes();
        System.out.println("Number of leaf nodes: " + leafCount);
    }
}
