class Solution {
    int max;
    Integer dp[][];
    public int maxProfit(int[] prices) {
        max = 0;
        dp = new Integer[prices.length][2];
        boolean buyflag = true;
        return maxProfit(prices,0,buyflag);
    }
    
    int maxProfit(int[] prices,int index,boolean buyflag){
        if(index>=prices.length){
            return 0;
        }
        if(buyflag && dp[index][1]!=null){
            return dp[index][1];
        }
        if(!buyflag && dp[index][0]!=null){
            return dp[index][0];
        }
        
        if(buyflag){
            return dp[index][1]=Math.max(-prices[index]+maxProfit(prices,index+1,!buyflag)
                            ,maxProfit(prices,index+1,buyflag));
        }else{
            return dp[index][0]=Math.max(
                            prices[index] + maxProfit(prices,index+1,!buyflag)
                            ,maxProfit(prices,index+1,buyflag));
        }
        
    }
}