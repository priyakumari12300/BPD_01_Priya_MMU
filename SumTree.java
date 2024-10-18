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

public class SumTree {

    // Function to convert a binary tree to a Sum Tree
    public int toSumTree(TreeNode node) {
        // Base case: empty tree
        if (node == null) {
            return 0;
        }

        // Recursively convert left and right subtrees
        int leftSum = toSumTree(node.left);
        int rightSum = toSumTree(node.right);

        // Store the original value of the node
        int oldVal = node.val;

        // Update the node's value to the sum of left and right subtrees
        node.val = leftSum + rightSum;

        // Return the sum of the original node value + subtree sums
        return node.val + oldVal;
    }

    // Helper function to print the inorder traversal of the tree
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        SumTree tree = new SumTree();
        
        System.out.println("Inorder traversal of the original tree:");
        tree.inorder(root);
        System.out.println();
        
        tree.toSumTree(root);

        System.out.println("Inorder traversal of the sum tree:");
        tree.inorder(root);
    }
}
