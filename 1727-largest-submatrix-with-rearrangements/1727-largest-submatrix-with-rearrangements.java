class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        for(int j = 0; j < matrix[0].length; j++){
            int sum = 0;
            for(int i = 0; i < matrix.length; i++){
                sum = (matrix[i][j] == 0)?0:(sum+matrix[i][j]);
                matrix[i][j] = sum;
            }
        }
    
        int ans = 0;
        
        for(int i = 0; i < matrix.length; i++){
            ans = Math.max(ans,findMaxArea(matrix[i]));
        }
        
        return ans;
    }
    
    int findMaxArea(int matrix[]){
        
        Arrays.sort(matrix);
        int ans = 0;
        int n = matrix.length;
        
       // Arrays.stream(matrix).forEach(System.out::print);
       // System.out.println();
        
        for(int i=0; i<matrix.length; i++){
            ans = Math.max(ans,matrix[i]*(n-i)); 
        }
        
        return ans;
    }
}