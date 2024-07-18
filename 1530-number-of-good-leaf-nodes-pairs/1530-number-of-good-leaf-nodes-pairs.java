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
    public int countPairs(TreeNode root, int distance) {
        return dfs(root, new ArrayList<>(), distance);
    }
    
    int dfs(TreeNode root, List<Integer> list, int distance) {
        
    if (root == null) return 0;
        
    if (root.left == null && root.right == null) {
        list.add(0);
        return 0;
    }
        
    int count = 0;
    List<Integer> ld = new ArrayList<>();
    List<Integer> rd = new ArrayList<>();
        
    int left = dfs(root.left, ld, distance);
    int right = dfs(root.right, rd, distance);
    
    for (int i = 0; i < ld.size(); i++) {
        for (int j = 0; j < rd.size(); j++) {
            if(ld.get(i) + rd.get(j) + 2 <= distance) count++;
        }
    }
        
    for (int l : ld) list.add(l + 1);
        
    for (int r : rd) list.add(r + 1);
        
    return count + left + right;
        
  }
}