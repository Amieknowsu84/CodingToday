class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        int totalSum = 0;

        if (node.left != null) {
            totalSum += sumNumbersHelper(node.left, currentSum);
        }

        if (node.right != null) {
            totalSum += sumNumbersHelper(node.right, currentSum);
        }

        return totalSum;
    }
}
