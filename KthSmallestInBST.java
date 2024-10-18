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

public class KthSmallestInBST {

    // Counter to keep track of the number of nodes visited
    private int count = 0;

    // Variable to store the result (Kth smallest element)
    private int result = -1;

    // Function to find the Kth smallest element in the BST
    public int kthSmallest(TreeNode root, int k) {
        // Perform in-order traversal
        inOrderTraversal(root, k);
        return result; // Return the Kth smallest element
    }

    // Helper function to perform in-order traversal
    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree first
        inOrderTraversal(node.left, k);

        // Increment the counter for each node visited
        count++;

        // Check if the current node is the Kth smallest
        if (count == k) {
            result = node.val;
            return; // Once the result is found, no need to continue
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        KthSmallestInBST tree = new KthSmallestInBST();
        int k = 3; // Example: find the 3rd smallest element
        int kthSmallest = tree.kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element in the BST is: " + kthSmallest);
    }
}
