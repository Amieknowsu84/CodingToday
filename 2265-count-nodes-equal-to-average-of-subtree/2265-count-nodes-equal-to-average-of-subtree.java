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
    
    int totalCnt;
    
    public int averageOfSubtree(TreeNode root) {
       totalCnt = 0;
       average(root);
       return totalCnt; 
    }
    
    Pair<Integer,Integer> average(TreeNode root) {
       if(root == null){
         return new Pair<>(0,0);
       }
       Pair<Integer,Integer> left = average(root.left);
       Pair<Integer,Integer> right = average(root.right);
        
       int cnt = left.getKey()+right.getKey()+1;
       int sum = left.getValue()+right.getValue()+root.val;
        
       if((sum/cnt) == root.val){
           totalCnt++;
       }
       
       return new Pair<>(cnt,sum);
    }
    
}