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
    
    int total;
    int sum;
    
    public int sumNumbers(TreeNode root) {
        sum=0;
        total=0;
        sumNumber(root);
        return total;
    }
    
    public void sumNumber(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            sum=sum*10+root.val;
            total+=sum;
            sum-=root.val;
            sum=sum/10;
            return;
        }
        sum=sum*10+root.val;
        sumNumber(root.left);
        sumNumber(root.right);
        sum-=root.val;
        sum=sum/10;
        
    }
    
   
    
}