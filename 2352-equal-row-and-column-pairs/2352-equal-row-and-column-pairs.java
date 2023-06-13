class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid[0].length;
        int k=0,sum=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               sum+=solve(i,0,0,j,n,grid);
            }
        }
        return sum;
    }
    
    int solve(int ci,int cj,int ri,int rj,int n,int[][] grid){
          for(int k=0;k<n;k++){
                if(grid[ci][cj]==grid[ri][rj]){
                    cj++;
                    ri++;
                }else{
                    return 0;
                }
          }
        return 1;
    }
}