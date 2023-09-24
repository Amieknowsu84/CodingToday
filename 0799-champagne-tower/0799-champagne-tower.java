class Solution {  
        
    public double champagneTower(int poured, int query_row, int query_glass) {
        double glasses[][]=new double[101][101];
        glasses[0][0]=poured;
        
        for(int i=0;i<query_row;i++){
            for(int j=0;j<=query_glass;j++){
                
                double remaining=Math.max(glasses[i][j]-1.0,0);
                glasses[i+1][j]+=remaining/2.0;
                glasses[i+1][j+1]+=remaining/2.0;
                
            }
        }
        
        
        return Math.min(glasses[query_row][query_glass],1.0);
    }
    
  
    
}