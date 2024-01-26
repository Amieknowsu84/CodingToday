class Solution {
    int mod = 1_000_000_000+7;
    int m;
    int n;
    int cnt;
    Integer[][][] dp;
    int maxMove;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
         this.m = m;
         this.n = n;
         this.cnt = 0;
         this.maxMove = maxMove;
         this.dp = new Integer[m][n][maxMove+1];
         return helper(maxMove,startRow,startColumn);    
    }
    
     int helper(int maxMove, int x, int y){
        if(x<0 || x>=m || y<0 || y>=n)return 1;
        if(maxMove<=0)return 0;
        if(dp[x][y][maxMove]!=null)return dp[x][y][maxMove];
        int res=0;
        res=(res+helper(maxMove-1, x+1, y))%mod;
        res=(res+helper(maxMove-1, x, y-1))%mod;
        res=(res+helper(maxMove-1, x-1, y))%mod;
        res=(res+helper(maxMove-1, x, y+1))%mod;
        dp[x][y][maxMove]=res;
        return res;

    }

}