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
    int maxDiff;
    
    public int maxAncestorDiff(TreeNode root) {
      maxDiff = 0;
      findMax(root);
      return maxDiff;  
        
    }
    
    int[] findMax(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }
        
        int rootVal = root.val;
        int[] left = findMax(root.left);
        int[] right = findMax(root.right);
        //System.out.println(root.val +" "+left+" "+right+" ");
        
        int min = Math.min(root.val,Math.min(left[0],right[0]));
        int max = Math.max(root.val,Math.max(right[1],left[1]));
        
        maxDiff = Math.max(root.val-min,Math.max(max-root.val,maxDiff));
        return new int[]{min,max};
    }
}