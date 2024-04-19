class Solution {
    public int numIslands(char[][] grid) {
        int cnt  = 0;
        
        for(int i = 0 ;i < grid.length; i++){
            for(int j= 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    cnt++;
                }
            }
        }
        
        return cnt;
        
    }
    
    void dfs(int i,int j,char[][] grid){
        if(i<0 || j<0 || i >= grid.length || j >= grid[0].length){
            return ;
        }
        
        if(grid[i][j] == '2' || grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '2';
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};
    
        for(int index=0; index<di.length; index++){
            dfs(i+di[index], j+dj[index], grid);
        }
        
    }
}