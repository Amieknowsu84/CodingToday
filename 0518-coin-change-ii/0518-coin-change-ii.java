class Solution {

    public int change(int amount, int[] coins) {
        int dp[]=new int[amount+1];
        dp[0]=1;
        
        for(int i=0;i<coins.length;i++){
            
            for(int amt=coins[i];amt<=amount;amt++)
                dp[amt]+=dp[amt-coins[i]];
            
        }
        
        return dp[amount];
        
    }
}