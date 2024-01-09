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
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leafs = new ArrayList<>();
        List<Integer> root2Leafs = new ArrayList<>();
        getLeafs(root1,root1Leafs);
        getLeafs(root2,root2Leafs);
        
        if(root1Leafs.size() == root2Leafs.size()){
            for(int i=0;i<root1Leafs.size();i++){
                if(root1Leafs.get(i) != root2Leafs.get(i)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
        
    }
    
    void getLeafs(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        getLeafs(root.left,list);
        getLeafs(root.right,list);
    }
}