class Solution {
    public int maxProfit(int t, int[] prices) {
        if (t == 0) {
            return 0;
        }
        
        int[][] prev = new int[2][t+1];
        int[][] curr = new int[2][t+1];
        Arrays.fill(prev[1], Math.max(-prices[prices.length-1],0));
        Arrays.fill(prev[0], prices[prices.length-1]);
    
        //prev[1][t] = prev[1][1] = Math.max(-prices[prices.length-1],0);
        //prev[0][t] = prev[0][1] = prices[prices.length-1];
        prev[1][0] = 0;
        prev[0][0] = 0;
        
        for(int i=prices.length-2;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<=t;k++)
                  if(j == 1)
                    curr[j][k] = Math.max(-prices[i]+prev[1-j][k],prev[j][k]);
                  else
                    curr[j][k] = Math.max(prices[i]+prev[1-j][k-1],prev[j][k]);
            }
            prev = curr;
            curr = new int[2][t+1];
            
        }
        
        return prev[1][t];
    }
}