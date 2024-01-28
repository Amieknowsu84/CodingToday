class Solution {
    int max;
    Integer dp[][][];
    
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][3];
        return maxProfit(prices,0,true,2);
    }
    
     int maxProfit(int[] prices,int index,boolean buyflag,int transaction){
        if(transaction <= 0 || index>=prices.length){
            return 0;
        }
        if(buyflag && dp[index][1][transaction]!=null){
             return dp[index][1][transaction];
        }
        if(!buyflag && dp[index][0][transaction]!=null){
             return dp[index][0][transaction];
        }
    
        if(buyflag){
            return dp[index][1][transaction] = Math.max(-prices[index]+maxProfit(prices,index+1,!buyflag,transaction)
                            ,maxProfit(prices,index+1,buyflag,transaction));
        }else{
            return dp[index][0][transaction] = Math.max(
                            prices[index] + maxProfit(prices,index+1,!buyflag,transaction-1)
                            ,maxProfit(prices,index+1,buyflag,transaction));
        }
        
    }
}