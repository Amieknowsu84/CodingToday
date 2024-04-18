class Solution {
    public int islandPerimeter(int[][] grid) {
        int si=-1,sj=-1;
        boolean found = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    si = i;
                    sj = j;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        
        return islandPerimeter(si,sj,grid);
    
    }
    
    public int islandPerimeter(int i,int j,int[][] grid) {
        
        if(i<0 || j<0 || i >= grid.length || j >= grid[0].length){
            return 1;
        }
        
        if(grid[i][j] == -1)
            return 0;
        
        if(grid[i][j] == 0)
            return 1;
        
        grid[i][j] = -1;
    
       
         return islandPerimeter(i+1,j,grid) +  islandPerimeter(i-1,j,grid)
            +  islandPerimeter(i,j-1,grid) +  islandPerimeter(i,j+1,grid);
        
    }
}