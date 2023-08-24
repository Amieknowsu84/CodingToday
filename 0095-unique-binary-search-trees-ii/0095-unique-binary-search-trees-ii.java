class Solution {
    public List<TreeNode> generateTrees(int n) {
       return construct(1,n);
    }
    
    //  [1,2,3]
    // 1,0  2,3  1,1 3,3 1,2 4,3
    // null  [2,3 3,2] 1 3 
    
    List<TreeNode> construct(int start,int n){
    
        List<TreeNode> result=new ArrayList<TreeNode>();
        
        if(start>n){
            result.add(null);
            return result;
        }else if(start==n){
            result.add(new TreeNode(start,null,null));
            return result;
        }
        

        for(int i=start ; i<=n ; i++){
            
            List<TreeNode> leftSubTree = construct(start,i-1);
            List<TreeNode> rightSubTree = construct(i+1,n);
        
                
               for(TreeNode leftTree : leftSubTree){
                  for(TreeNode rightTree : rightSubTree){
                      TreeNode node=new TreeNode(i,leftTree,rightTree);
                      result.add(node);
                  }
               }
                
        }
        
        return result;
    }
}