import java.util.*;

public class BSTChildrenNodes {
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

    public BSTChildrenNodes() {
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

    // Function to find and print children of a node in BST
    public void findChildren(int data) {
        Node node = findNode(root, data);
        if (node != null) {
            System.out.print("Children of node " + data + ": ");
            if (node.left != null)
                System.out.print(node.left.data + " ");
            if (node.right != null)
                System.out.print(node.right.data + " ");
            System.out.println();
        } else {
            System.out.println("Node " + data + " not found in BST.");
        }
    }

    private Node findNode(Node root, int data) {
        if (root == null || root.data == data)
            return root;

        if (data < root.data)
            return findNode(root.left, data);
        else
            return findNode(root.right, data);
    }

    // Main method to test finding children of a node
    public static void main(String[] args) {
        BSTChildrenNodes bst = new BSTChildrenNodes();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.inorderTraversal();

        int nodeToFindChildren = 50;
        bst.findChildren(nodeToFindChildren);
    }
}
