class Solution {
    static int dp[][]=new int[101][101];
     {
        for(int arr[]:dp)
        Arrays.fill(arr,-1);
     }
    
    public int uniquePaths(int m, int n) {
        
        if(m<=0|n<=0)
            return 0;
        if(m==1||n==1)
            return 1;
        if(dp[m][n]!=-1)
            return dp[m][n];
        return dp[m][n]=uniquePaths(m-1,n)+uniquePaths(m,n-1);
        
    }
}