class Solution {
    public int minFallingPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return minFallingPathSum(-1,0,grid,dp);
    }
    
    public int minFallingPathSum(int prevCol,int i,int[][] grid,Integer[][] dp){
        if(i == grid.length){
            //System.out.println();
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int j=0;j<grid[0].length;j++){
            if(j!=prevCol){
                int current = 0;
                if(dp[i][j] != null){
                    current = dp[i][j];
                }else{
                    dp[i][j] = current = grid[i][j]+minFallingPathSum(j,i+1,grid,dp);
                }
                min=Math.min(min,current);
            }
        }
        return min;
    }
}