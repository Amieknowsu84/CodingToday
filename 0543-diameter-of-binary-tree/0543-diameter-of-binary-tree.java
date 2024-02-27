class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameterOfBinaryTreeHelper(root, diameter);
        return diameter[0];
    }
    
    private int diameterOfBinaryTreeHelper(TreeNode root, int[] diameter) {
        if (root == null) {
            // If root is null, depth is 0
            return 0;
        }
        
        // Calculate the depths of left and right subtrees
        int leftDepth = diameterOfBinaryTreeHelper(root.left, diameter);
        int rightDepth = diameterOfBinaryTreeHelper(root.right, diameter);
        
        // Update the diameter if the sum of depths of left and right subtrees is greater
        diameter[0] = Math.max(diameter[0], leftDepth + rightDepth);
        
        // Return the depth of the current node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
