/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(root == null)
            return root;
        
        if(depth-1 == 0){
            TreeNode left = new TreeNode(val);
            left.left = root;
            return left;
        }
    
        return addRow(root, val, depth);
    }
    
    public TreeNode addRow(TreeNode root, int val, int depth) {
        
        if(root == null)
            return root;
        
        if(depth-1 == 1){
            TreeNode left = new TreeNode(val);
            left.left = root.left;
            
            TreeNode right = new TreeNode(val);
            right.right = root.right;
            root.left = left;
            root.right = right;
        }
        
        addRow(root.left, val, depth-1);
        addRow(root.right, val, depth-1);
        return root;      
        
    }
}