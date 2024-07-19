class Solution {
    // [[3,7,8],
    //  [9,11,13],
    //  [15,16,17]]
    public List<Integer> luckyNumbers (int[][] matrix) {
      
       List<Integer> result = new ArrayList<>();
       
       for(int i=0; i<matrix.length; i++){
           int minRow = 0;
           for(int j=0; j<matrix[0].length; j++){
               if(matrix[i][minRow] > matrix[i][j]){
                   minRow = j;
               }
           }
           
           boolean canbeAdded = true;
           for(int k=0;k<matrix.length;k++){
               if(matrix[k][minRow] > matrix[i][minRow]){
                   canbeAdded = false;
                   break;
               }
           }
           if(canbeAdded){
               result.add(matrix[i][minRow]);
           }
       }
        
       return result;
    }
}