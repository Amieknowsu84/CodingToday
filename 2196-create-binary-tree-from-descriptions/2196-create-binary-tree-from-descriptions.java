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
    public TreeNode createBinaryTree(int[][] descriptions) {
       Map<Integer,TreeNode> map = new HashMap<>();
       
       for(int[] desc: descriptions){
          TreeNode parent = map.getOrDefault(desc[0],new TreeNode(desc[0]));
          TreeNode child = map.getOrDefault(desc[1],new TreeNode(desc[1]));
          boolean isLeft = desc[2] == 0 ? false: true;
          if(isLeft){
              parent.left = child;
          }else{
              parent.right = child;
          }
          if(!map.containsKey(parent.val)){
              map.put(parent.val,parent);
          }
           
          if(!map.containsKey(child.val)){
              map.put(child.val,child);
          }
        }
        
        for(int[] desc: descriptions){
          map.remove(desc[1]);
        }
        
        TreeNode root = null;
        for(Map.Entry<Integer,TreeNode> entry:map.entrySet()){
            root = entry.getValue();
        }
        
        return root;
                                               
    }
}