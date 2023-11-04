class Solution {
    int m;
    int n;  
    
    public int countSquares(int[][] matrix) {
       
        int[][] dp=new int[matrix.length][matrix[0].length];
        
        int cnt = 0;
        m = matrix.length;
        n = matrix[0].length;
        int val = 0;
        
        for(int i=0; i<dp.length; i++){ 
            for(int j=0; j<dp[0].length; j++){
                val = 0;
                if(isInboundary(i-1,j-1) && isInboundary(i,j-1)
                   && isInboundary(i-1,j) && matrix[i][j]!=0 ){
                    val = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
                }else{
                    val = matrix[i][j];
                }
                cnt+= val;
                dp[i][j] = val;
            }
        }
        
        return cnt;
        
    }
    
    boolean isInboundary(int i,int j){
      return (i>=0 && i<m && j>=0 && j<n);
    }
    
    
}