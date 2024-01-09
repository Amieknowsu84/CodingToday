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
    
    Map<Integer,Integer> preOrderMap; 
        
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderMap = new HashMap<>();
        for(int i=0; i<preorder.length; i++){
            preOrderMap.put(preorder[i],i);
        }
        
        return buildTree(inorder,0,inorder.length-1);
    }
    
    
    int findPos(int[] inorder,int start,int end){
        int pos = start;
        int current = inorder[start];
        //System.out.println(start+" "+end);
        for(int i=start;i<=end;i++){
            if(preOrderMap.get(inorder[i])<preOrderMap.get(current)){
                pos = i;
                current = inorder[i];
            }
        }
        return pos;
    }
    
    
    TreeNode buildTree(int[] inorder,int start,int end) {
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(inorder[start]);
        }
        
        
        int rootPos = findPos(inorder,start,end);
        TreeNode root = new TreeNode(inorder[rootPos]);
        
        root.left = buildTree(inorder,start,rootPos-1);
        root.right = buildTree(inorder,rootPos+1,end);
        return root;
    }
}