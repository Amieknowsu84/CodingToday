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
   int maxDepth;
   int depth; 
   int val; 
        
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        findBottonLeftValue(root);
        return val;
    }
    
    
    void findBottonLeftValue(TreeNode root){
        if(root == null){
            return;
        }
        
        if(depth > maxDepth){
            maxDepth = depth;
            val = root.val;
        }
        
        depth+=1;
        findBottonLeftValue(root.left);    
        findBottonLeftValue(root.right); 
        depth-=1;
    }
}