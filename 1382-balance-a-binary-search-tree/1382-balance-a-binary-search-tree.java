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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        
        return constructBST(list,0,list.size()-1);
    }
    
    
    TreeNode constructBST( List<Integer> list, int start, int end){
        if(start>end){
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode nroot = new TreeNode(list.get(mid));
        nroot.left = constructBST(list, start,mid-1);
        nroot.right = constructBST(list, mid+1, end);
        return nroot;
    }
    
    
    
    void inorderTraversal(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }
    
    
}