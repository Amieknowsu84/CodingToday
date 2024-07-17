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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> treeNodes = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int node: to_delete){
            toDelete.add(node);
        }
        if(!toDelete.contains(root.val)){
            treeNodes.add(root);
        }
        delNodes(root, treeNodes, toDelete);
        return treeNodes;
    }
    
    TreeNode delNodes(TreeNode root,List<TreeNode> treeNodes,Set<Integer> toDelete){
        if(root == null){
            return root;
        }
        
        TreeNode node = root;
        
        if(toDelete.contains(root.val)){
            node = null;
        }
        
        TreeNode left = delNodes(root.left, treeNodes,toDelete);
        TreeNode right = delNodes(root.right, treeNodes,toDelete);
        if(node!=null){
            node.left = left;
            node.right = right;
        }else{
            if(left!=null){
                 treeNodes.add(left);
            }
            if(right!=null){
                treeNodes.add(right);
            }
        }
        
        return node;
    }
}