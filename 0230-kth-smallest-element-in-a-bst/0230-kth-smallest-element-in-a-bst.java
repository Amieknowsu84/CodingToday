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
    int k;
    int elem;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        this.elem=-1;
        kthSmallest(root);
        return elem;
    }
    
    
    public void kthSmallest(TreeNode root) {
        if(root == null){
            return ;
        }
        if(elem != -1){
            return ;
        }
        
        kthSmallest(root.left);
        k--;
        if(k==0){
            elem = root.val;
        }
        kthSmallest(root.right);
    }
}