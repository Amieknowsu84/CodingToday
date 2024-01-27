class Solution {
    public int kInversePairs(int n, int k) {
        
   int dp[][] = new int[1001][1001];
        for (int i = 0; i < dp.length; i++) {
           for(int j=0;j<dp[0].length;j++){
               dp[i][j]=-1;
           }
        }
        return travel(n, k, dp);
    }

    public static int travel(int n, int k, int dp[][]) {
        if (n == 0)
            return 0;

        if (k <= 0)
            return 1;

        if (dp[n][k] != -1)
            return dp[n][k];

        int inv = 0;
        for (int i = 0; i <=Math.min(k,n-1); i++) {
            inv = (inv + travel(n - 1, k - i, dp)) % 1000000007;
        }
        dp[n][k] = inv;
        return dp[n][k];
    }
}