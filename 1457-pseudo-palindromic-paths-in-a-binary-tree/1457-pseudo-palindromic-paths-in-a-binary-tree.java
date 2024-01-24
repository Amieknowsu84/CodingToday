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
    private int cnt;
    private Map<Integer, Integer> map;

    public int pseudoPalindromicPaths(TreeNode root) {
        cnt = 0;
        map = new HashMap<>();
        inorder(root);
        return cnt;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic()) {
                cnt++;
            }
            map.put(root.val, map.get(root.val) - 1);
            if (map.get(root.val) == 0) {
                map.remove(root.val);
            }
            return;
        }

        inorder(root.left);
        inorder(root.right);

        map.put(root.val, map.get(root.val) - 1);
        if (map.get(root.val) == 0) {
            map.remove(root.val);
        }
    }

    private boolean isPseudoPalindromic() {
        int cntOdd = 0;
        for (int v : map.values()) {
            if (v % 2 != 0) {
                cntOdd++;
            }
            if (cntOdd > 1) {
                return false;
            }
        }
        return true;
    }
}
