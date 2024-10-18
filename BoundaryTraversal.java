import java.util.*;

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

public class BoundaryTraversal {

    // Function to check if a node is a leaf node
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // Function to add left boundary nodes (excluding leaf nodes)
    private void addLeftBoundary(TreeNode node, List<Integer> boundary) {
        TreeNode curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                boundary.add(curr.val);
            }
            curr = (curr.left != null) ? curr.left : curr.right; // Move to the next boundary node
        }
    }

    // Function to add right boundary nodes (excluding leaf nodes)
    private void addRightBoundary(TreeNode node, List<Integer> boundary) {
        TreeNode curr = node.right;
        Stack<Integer> stack = new Stack<>(); // Stack to reverse the right boundary order
        while (curr != null) {
            if (!isLeaf(curr)) {
                stack.push(curr.val);
            }
            curr = (curr.right != null) ? curr.right : curr.left; // Move to the next boundary node
        }

        // Add nodes from stack to list (in reverse order)
        while (!stack.isEmpty()) {
            boundary.add(stack.pop());
        }
    }

    // Function to add leaf nodes
    private void addLeaves(TreeNode node, List<Integer> boundary) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            boundary.add(node.val);
        } else {
            addLeaves(node.left, boundary);
            addLeaves(node.right, boundary);
        }
    }

    // Function to perform the boundary traversal
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();

        if (root == null) {
            return boundary;
        }

        // Add the root node (if it's not a leaf node)
        if (!isLeaf(root)) {
            boundary.add(root.val);
        }

        // Add the left boundary (excluding leaf nodes)
        addLeftBoundary(root, boundary);

        // Add all leaf nodes
        addLeaves(root, boundary);

        // Add the right boundary (excluding leaf nodes, in reverse order)
        addRightBoundary(root, boundary);

        return boundary;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        BoundaryTraversal tree = new BoundaryTraversal();
        List<Integer> boundary = tree.boundaryOfBinaryTree(root);

        System.out.println("Boundary Traversal of the binary tree is:");
        for (int val : boundary) {
            System.out.print(val + " ");
        }
    }
}
