class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int dp[][]=new int[101][101];
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    dp[i][j]=j>0 ? dp[i][j-1]:0;
                }else if(j==0){
                    dp[i][j] = i>0? dp[i-1][j]:0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        
        
        return dp[m-1][n-1];
        
    }
}