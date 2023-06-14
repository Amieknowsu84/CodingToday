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
    public int getMinimumDifference(TreeNode root) {
        Integer a[]=new Integer[1];
     return inorder(root,a);      
    }
    
    public int inorder(TreeNode root,Integer a[]) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE,cur=Integer.MAX_VALUE;
        
        if(root.left != null){
           left = inorder(root.left,a);
        }
        
        if(a[0] != null){
            cur = Math.abs(root.val-a[0]);
        }
        
        a[0] = root.val;
        
        if(root.right != null){
            right = inorder(root.right,a);
        }
        
        return Math.min(Math.min(left,right),cur);
        
    
    }
    
}