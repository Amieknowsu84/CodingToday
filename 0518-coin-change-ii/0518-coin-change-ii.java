class Solution {

    Integer dp[][];
    
    public int change(int amount, int[] coins) {
        return  bottomUp(amount, coins);
    }
    
    public int bottomUp(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for(int i=1;i<=coins.length;i++){
            dp[i][0] = 1;
            for(int j=1;j<=amount;j++){
                dp[i][j] = ((j>=coins[i-1]) ? dp[i][j-coins[i-1]] : 0)
                          + dp[i-1][j];
            }
        }
        return dp[coins.length][amount];
    }
    
    
    public int topDown(int amount, int[] coins) {
        dp=new Integer[coins.length][amount+1];
        return solve(0,amount,coins);
    }
    
    //   0 1 2 3 4 5
    //[1,
    // 2,
    // 5]
                  
    
    int solve(int index,int target,int coins[]){
        if(target==0){
            return 1;
        }
        if(index == coins.length){
            return 0;
        }
        if(dp[index][target]!=null){
            return dp[index][target];
        }
    
        return dp[index][target]=
            ((target>=coins[index])?solve(index,target-coins[index],coins):0)
            +
            solve(index+1,target,coins);
    }
}