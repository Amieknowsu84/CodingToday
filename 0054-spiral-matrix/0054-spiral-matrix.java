class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      int rs = 0, re = matrix.length-1, cs = 0, ce = matrix[0].length-1;
      List<Integer> result = new ArrayList<>();
        
      while(rs<=re && cs<=ce){
          
          for(int j=cs;j<=ce;j++)
              result.add(matrix[rs][j]);
          rs++;
          
          if(rs > re)
              continue;
          
          for(int i = rs;i<=re;i++)
              result.add(matrix[i][ce]);
          ce--;
          
          if(cs > ce)
              continue;
          
          
           for(int l=ce;l>=cs;l--)
               result.add(matrix[re][l]);
               
          re--;
          
          if(rs > re)
              continue;
          for(int k=re;k>=rs;k--)
              result.add(matrix[k][cs]);
          cs++;   
          
      }
      
     
      return result;  
         
    }
}