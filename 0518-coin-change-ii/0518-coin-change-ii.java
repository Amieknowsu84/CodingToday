class Solution {

    Integer dp[][];
    
    public int change(int amount, int[] coins) {
        dp=new Integer[coins.length][amount+1];
        return solve(0,amount,coins);
    }
    
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