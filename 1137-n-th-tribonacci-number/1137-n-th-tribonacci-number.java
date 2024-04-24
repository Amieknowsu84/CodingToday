class Solution {

    public int tribonacci(int n) {
        if(n <= 1)
            return n;
        
        int dp[] = new int[4];
        dp[1] = dp[2] = 1;
        
        if(n == 2)
            return dp[2];
        
        for(int i = 3; i <= n; i++){
            dp[3] = dp[0]+dp[1]+dp[2];
            //4     1      2     3
            dp[0] = dp[1];
            //1     2
            dp[1] = dp[2];
            //2      3
            dp[2] = dp[3];
            //3      4
            // 4 element of array i.e at 3rd index, always holds the nth value
            
        }
        
        return dp[3];
    }
    
}