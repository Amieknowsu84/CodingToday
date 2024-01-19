class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length; 
       int[] prev = new int[n];
       int[] curr = new int[n]; 
       int minValue = Integer.MAX_VALUE; 
    
       for(int i=m-1; i>=0; i--){
           for(int j=0; j<n; j++){
               if(i==m-1){
                   curr[j]=matrix[i][j];
               }
               else{
                   int val = prev[j];
                   if(j+1 < n){
                       val = Math.min(val,prev[j+1]);
                   }
                   if(j-1 >= 0){
                       val = Math.min(val,prev[j-1]);
                   }
                   curr[j] = val + matrix[i][j];
               }
               if(i==0){
                   minValue = Math.min(minValue,curr[j]);
               }
           }
           prev = curr;
           curr = new int[n];
       }
       
        return minValue;
    
    }
}