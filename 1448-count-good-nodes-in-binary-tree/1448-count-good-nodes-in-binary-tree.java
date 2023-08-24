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
    public int goodNodes(TreeNode root) {
       return countGoodNodes(root,Integer.MIN_VALUE);
    }
    
     int countGoodNodes(TreeNode root,int max){
         if(root == null){
             return 0;
         }
        
         int cnt=0;
         if(root.val>=max){
             cnt=1;
         }
         max = Math.max(root.val,max);
         
         return cnt+countGoodNodes(root.left,max)
                +countGoodNodes(root.right,max);   
     }
}