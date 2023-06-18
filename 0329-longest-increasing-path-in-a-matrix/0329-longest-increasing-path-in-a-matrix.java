class Solution {
    
    int m;
    int n;
    
    public int longestIncreasingPath(int[][] matrix) {
       m=matrix.length;
       n=matrix[0].length;
       int[][] dp=new int[m][n];
       for(int row[]:dp){
          Arrays.fill(row,-1);
       }
        
      int max=0;
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               max=Math.max(dfs(matrix,dp,i,j),max);
           }
       }
        
       return max; 
    }
    
    
    int dfs(int[][] matrix,int[][] dp,int i,int j){
         
        if(!inBoundaries(i,j)){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
            
        int row[]={1,0,0,-1};
        int col[]={0,1,-1,0};
        int max=0;
        for(int k=0;k<row.length;k++){
            int ni=i+row[k];
            int nj=j+col[k];
           if(inBoundaries(ni,nj) && matrix[i][j]<matrix[ni][nj] ){
               max=Math.max(max,dfs(matrix,dp,ni,nj));
           }
        }
        
        return dp[i][j]=1+max;
        
    }
    
    boolean inBoundaries(int i, int j){
        return (i>=0 && i<m && j>=0 && j<n);
    }
}