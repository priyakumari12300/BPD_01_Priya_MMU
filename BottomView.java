import java.util.*;

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

// Class to store tree node and its horizontal distance
class Pair {
    TreeNode node;
    int hd; // horizontal distance

    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class BottomView {

    // Function to print the bottom view of the binary tree
    public void printBottomView(TreeNode root) {
        if (root == null) {
            return;
        }

        // TreeMap to store nodes at each horizontal distance
        // It stores the most recent node at each horizontal distance (i.e., the bottom-most node)
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Queue for level order traversal, storing pairs of node and its horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // Overwrite the current entry at horizontal distance with the current node's value
            map.put(hd, node.val);

            // If there is a left child, add it to the queue with horizontal distance - 1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // If there is a right child, add it to the queue with horizontal distance + 1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print the bottom view (values from TreeMap)
        for (Integer key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        BottomView tree = new BottomView();
        System.out.println("Bottom view of the binary tree is:");
        tree.printBottomView(root);
    }
}
