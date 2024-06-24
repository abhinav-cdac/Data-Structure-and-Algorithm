import java.util.*;

public class BSTSiblings {
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

    public BSTSiblings() {
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

    // Function to print all pairs of siblings in BST
    public void printSiblings() {
        List<List<Integer>> siblings = findSiblings(root);
        if (siblings.isEmpty()) {
            System.out.println("No siblings found in the BST.");
        } else {
            System.out.println("Pairs of siblings in the BST:");
            for (List<Integer> pair : siblings) {
                System.out.println(pair.get(0) + " and " + pair.get(1));
            }
        }
    }

    private List<List<Integer>> findSiblings(Node root) {
        List<List<Integer>> siblings = new ArrayList<>();
        if (root == null)
            return siblings;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null && curr.right != null) {
                    levelNodes.add(curr.left.data);
                    levelNodes.add(curr.right.data);
                }
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            if (levelNodes.size() == 2)
                siblings.add(levelNodes);
        }

        return siblings;
    }

    // Main method to test finding siblings in BST
    public static void main(String[] args) {
        BSTSiblings bst = new BSTSiblings();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.inorderTraversal();

        bst.printSiblings();
    }
}
