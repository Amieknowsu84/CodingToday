class Solution {
    
    int ob[][];
    int data[][];
    
    int countPaths(int i,int j){
        
        if(i<0||j<0||i>=ob.length||j>=ob[0].length||ob[i][j]==1)
            return 0;
        if(i==ob.length-1&&j==ob[0].length-1)
            return 1;
        if(data[i][j]!=-1)
            return data[i][j];
        return data[i][j]=countPaths(i,j+1)+countPaths(i+1,j);
             
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      
        this.ob=obstacleGrid;
        this.data=new int[ob.length][ob[0].length];
        
        for(int a[]:data){
            Arrays.fill(a,-1);
        }
        
        return countPaths(0,0);
    }
    
}