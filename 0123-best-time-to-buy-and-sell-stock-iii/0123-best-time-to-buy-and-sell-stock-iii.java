class Solution {
    int max;
    Integer dp[][][];
    
    public int maxProfit(int[] prices) {
        // dp = new Integer[prices.length][2][3];
        // return maxProfit(prices,0,true,2);
        
        
        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];
        prev[1][2] = prev[1][1] = Math.max(-prices[prices.length-1],0);
        prev[0][2] = prev[0][1] = prices[prices.length-1];
        // prev[1][0] = 0;
        // prev[0][0] = 0;
        
        for(int i=prices.length-2;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<=2;k++)
                  if(j == 1)
                    curr[j][k] = Math.max(-prices[i]+prev[1-j][k],prev[j][k]);
                  else
                    curr[j][k] = Math.max(prices[i]+prev[1-j][k-1],prev[j][k]);
            }
            prev = curr;
            curr = new int[2][3];
            
        }
        
        return prev[1][2];
        
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