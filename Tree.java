// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Tree {

    // Function to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper function to check height and determine if tree is balanced
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: empty tree is balanced
        }

        // Check height of left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Not balanced
        }

        // Check height of right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Not balanced
        }

        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Not balanced
        }

        // Return height of the tree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        Tree tree = new Tree();
        if (tree.isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
