class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
       
        int dp[]=new int[pairs.length];
        int gmax=0;
        
        for(int i=0;i<pairs.length;i++){
            
            int max=0;
            for(int j=i-1;j>=0;j--){
                //System.out.println(pairs[j][1]+" "+pairs[i][1]);
                if(pairs[j][1] < pairs[i][0]){
                    //System.out.println(pairs[j][1]+" "+pairs[i][1]+" "+dp[j]+" ");
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            if(dp[i]>gmax){
                gmax=dp[i];
            }
        }
        
        return gmax;
    }
}