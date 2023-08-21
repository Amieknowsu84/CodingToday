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
    
    int maxSum;
    
    public int maxPathSum(TreeNode root) {
        this.maxSum = Integer.MIN_VALUE;
        findMaxPath(root);
        return maxSum;
    }
    
    int findMaxPath(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left=findMaxPath(root.left);
        int right=findMaxPath(root.right);
        int onlyNodeAsPath=root.val;
        
        int pathWithoutRootAsIntermediateNode=Math.max(left+root.val,right+root.val);
        int pathWithRootAsIntermediateNode=left+right+root.val;
        
        int currentMax = Math.max
            (onlyNodeAsPath,Math.max(pathWithoutRootAsIntermediateNode,pathWithRootAsIntermediateNode));
        
        if(currentMax > maxSum){
            maxSum=currentMax;
        }

        return Math.max(onlyNodeAsPath,pathWithoutRootAsIntermediateNode);
        
    }
}