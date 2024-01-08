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
**/
    
    
class Solution {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
       diameter = 0;
       length(root);
       return diameter;    
    }
    
    
    int length(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = length(root.left);
        int right = length (root.right);
        diameter = Math.max(diameter,left+right);
        
        return 1+ Math.max(left,right);
    }
    
}