import java.util.Stack;

public class PreorderValidation {

    // Function to validate the preorder traversal of a BST
    public static boolean isValidPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;

        for (int value : preorder) {
            // If the current value is less than the lower bound, it's not valid
            if (value < lowerBound) {
                return false;
            }

            // Pop elements from the stack while they are smaller than the current value
            // This means we are moving to the right subtree, so we update the lower bound
            while (!stack.isEmpty() && value > stack.peek()) {
                lowerBound = stack.pop();
            }

            // Push the current value onto the stack
            stack.push(value);
        }

        return true; // If no violations, the preorder is valid
    }

    public static void main(String[] args) {
        // Example 1: Valid Preorder
        int[] preorder1 = {5, 2, 1, 3, 6};
        System.out.println("Is valid preorder: " + isValidPreorder(preorder1)); // Output: true

        // Example 2: Invalid Preorder
        int[] preorder2 = {5, 2, 6, 1, 3};
        System.out.println("Is valid preorder: " + isValidPreorder(preorder2)); // Output: false
    }
}
