class Solution {
    
    Integer dp[][][];
    int grid[][];
    
    int dfs(int row,int column1,int column2){
        
    
        if(column1<0||column2<0||row>=dp.length||
           column1>=dp[0].length||column2>=dp[0].length){
            return 0;
        }
        
        if(dp[row][column1][column2]!=null){
            return dp[row][column1][column2];
        }
        
        int maxCherryForSubProblems=0;
        
        for(int c1=-1;c1<=1;c1++){
            for(int c2=-1;c2<=1;c2++){
                
                maxCherryForSubProblems
                    =Math.max( maxCherryForSubProblems,
                               dfs(row+1,column1+c1,column2+c2) );

            }
        }
        
        
        maxCherryForSubProblems+=
            (column1==column2)?grid[row][column1]:(grid[row][column1]+grid[row][column2]);
        
            
       return dp[row][column1][column2]=maxCherryForSubProblems;
        
        
        
    }
    
    public int cherryPickup(int[][] grid) {
    
        int row=grid.length;
        int column=grid[0].length;
        
        dp=new Integer[row][column][column];
        this.grid=grid;
        
        return dfs(0,0,column-1);
        
        
    }
}