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
            return 0;
        }
        
        if(grid[i][j] == -1)
            return 0;
        
        if(grid[i][j] == 0)
            return 0;
        
        grid[i][j] = -1;
        
        int cnt = getCnt(i,j,grid);
       
        
         cnt += islandPerimeter(i+1,j,grid) +  islandPerimeter(i-1,j,grid)
            +  islandPerimeter(i,j-1,grid) +  islandPerimeter(i,j+1,grid);
        
        
        
        return cnt;
        
    }
    
    int getCnt(int i,int j,int[][] grid){
        int cnt = 0;
    
        if(i-1 < 0 || grid[i-1][j] == 0){
            cnt+=1;
        }
        
        if(j-1 < 0 || grid[i][j-1] == 0){
            cnt+=1;
        }
        
        if(i+1 >= grid.length || grid[i+1][j] == 0){
            cnt+=1;
        }
        
        if(j+1 >= grid[0].length || grid[i][j+1] == 0){
            cnt+=1;
        }
         //System.out.println(i+" "+j+" "+cnt);
        return cnt;
    }
}