class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
       
        int dp[]=new int[pairs.length];
        int gmax=0;
        
        for(int i=0;i<pairs.length;i++){
            
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(pairs[j][1] < pairs[i][0]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            gmax=Math.max(gmax,dp[i]);
        }
        
        return gmax;
    }
}