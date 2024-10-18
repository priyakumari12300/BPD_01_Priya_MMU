// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinaryTreeToDLL {

    // Head of the doubly linked list
    private TreeNode head = null;

    // Previous pointer to keep track of the previous node in the DLL
    private TreeNode prev = null;

    // Function to convert a binary tree to a doubly linked list
    public void convertToDLL(TreeNode root) {
        if (root == null) {
            return;
        }

        // Recursively convert the left subtree
        convertToDLL(root.left);

        // Now convert the current node
        if (prev == null) {
            // This node becomes the head of the doubly linked list
            head = root;
        } else {
            // Connect the current node with the previous node in DLL
            prev.right = root;
            root.left = prev;
        }

        // Mark this node as the previous one for the next iteration
        prev = root;

        // Recursively convert the right subtree
        convertToDLL(root.right);
    }

    // Function to print the doubly linked list
    public void printDLL(TreeNode node) {
        TreeNode curr = node;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        BinaryTreeToDLL converter = new BinaryTreeToDLL();
        converter.convertToDLL(root);

        // Print the resulting doubly linked list
        System.out.println("Doubly Linked List (in-order traversal):");
        converter.printDLL(converter.head);
    }
}
