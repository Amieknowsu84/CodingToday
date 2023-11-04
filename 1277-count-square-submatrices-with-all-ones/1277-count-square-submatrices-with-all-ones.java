class Solution {
    int m;
    int n;  
    
    public int countSquares(int[][] matrix) {
       
        
        int prev[] = new int[matrix[0].length];
        int curr[] = new int[matrix[0].length];
        
        
        int cnt = 0;
        m = matrix.length;
        n = matrix[0].length;
        int val = 0;
        
        for(int i=0; i<matrix.length; i++){ 
            for(int j=0; j<matrix[0].length; j++){
                val = 0;
              if(isInboundary(i-1,j-1) && isInboundary(i,j-1)
                   && isInboundary(i-1,j) && matrix[i][j]!=0 ){
                    val = Math.min(Math.min(prev[j-1],prev[j]),curr[j-1]) + 1;
                }else{
                    val = matrix[i][j];
                }
                cnt+= val;
                curr[j] = val;
            }
             prev = curr;
             curr = new int[matrix[0].length];
        }
        
        return cnt;
        
    }
    
    boolean isInboundary(int i,int j){
      return (i>=0 && i<m && j>=0 && j<n);
    }
    
    
}