import java.util.*;

public class BSTParentNode {
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

    public BSTParentNode() {
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

    // Function to find and print parent of a node in BST
    public void findParent(int data) {
        Node parent = findParentRec(root, data);
        if (parent != null)
            System.out.println("Parent of node " + data + " is: " + parent.data);
        else
            System.out.println("Node " + data + " is the root or not found in BST.");
    }

    private Node findParentRec(Node root, int data) {
        if (root == null || root.data == data)
            return null;

        if ((root.left != null && root.left.data == data) || (root.right != null && root.right.data == data))
            return root;

        if (data < root.data)
            return findParentRec(root.left, data);
        else
            return findParentRec(root.right, data);
    }

    // Main method to test finding parent of a node
    public static void main(String[] args) {
        BSTParentNode bst = new BSTParentNode();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.inorderTraversal();

        int nodeToFindParent = 60;
        bst.findParent(nodeToFindParent);
    }
}
