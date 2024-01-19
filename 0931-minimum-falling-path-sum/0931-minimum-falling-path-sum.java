class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length; 
       int[][] dp = new int[m][n];
       int minValue = Integer.MAX_VALUE; 
    
       for(int i=m-1; i>=0; i--){
           for(int j=0; j<n; j++){
               if(i==m-1){
                   dp[i][j]=matrix[i][j];
               }
               else{
                   int val = dp[i+1][j];
                   if(j+1 < n){
                       val = Math.min(val,dp[i+1][j+1]);
                   }
                   if(j-1 >= 0){
                       val = Math.min(val,dp[i+1][j-1]);
                   }
                   dp[i][j] = val + matrix[i][j];
               }
               
               
               if(i==0){
                   minValue = Math.min(minValue,dp[i][j]);
               }
           }
       }
       
        
        return minValue;
    
    }
}