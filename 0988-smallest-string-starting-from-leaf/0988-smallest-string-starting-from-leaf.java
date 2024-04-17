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
    String result;
    
    public String smallestFromLeaf(TreeNode root) {
        result = null;
        smallestFromLeaf(new StringBuilder(),root);
        return result;
    }
    
    
    void smallestFromLeaf(StringBuilder sb,TreeNode root){
        
        if(root == null){
            return;
        }
        
        char value = (char)('a'+root.val);
        sb.append(value);
        
        if(root.left == null && root.right == null){
           String current = new StringBuilder(sb).reverse().toString();
           //System.out.println(current);
           if(result == null || current.compareTo(result) < 0){
               result = current;
           }
        }else{
            smallestFromLeaf(sb,root.left);
            smallestFromLeaf(sb,root.right);
        }

        sb.setLength(Math.max(sb.length() - 1, 0));
    }
}