class Solution {
    int max;
    Integer dp[][];
    public int maxProfit(int[] prices) {
        max = 0;
        //dp = new Integer[prices.length][2];
        //boolean buyflag = true;
       // return maxProfit(prices,0,buyflag);
        //dp[prices.length-1][1] = Math.max(-prices[prices.length-1],0);
        //dp[prices.length-1][0] = prices[prices.length-1];
        
        int[] prev = new int[2];
        int[] curr = new int[2];
        prev[1] = Math.max(-prices[prices.length-1],0);
        prev[0] = prices[prices.length-1];
        
        for(int i=prices.length-2;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j == 1)
                 curr[j] = Math.max(-prices[i]+prev[1-j],prev[j]);
                else
                 curr[j] = Math.max(prices[i]+prev[1-j],prev[j]);
            }
            prev = curr;
            curr = new int[2];
            
        }
        
        return prev[1];
        
        
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