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
    
    Map<String,Integer> map;
    List<TreeNode>  result;
        
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        map = new HashMap<>();
        result = new ArrayList<>();
        findDuplicates(root);
        return result;
    }
    
    String findDuplicates(TreeNode root){
        if(root == null){
            return "null";
        }
     
        String res=root.val+","+findDuplicates(root.left)
                   +","+findDuplicates(root.right);
        int val= map.getOrDefault(res,0);
        if(val == 0){
             map.put(res,1);
        }else if(val == 1){
            map.put(res,2);
            result.add(root);
        }
        
        return res;
        
    }
    
}