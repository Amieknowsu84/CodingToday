class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int max = 0;
        
        for(int i=s.length()-1; i>=0; i--){
            
            if(i == s.length()-1){
                dp[s.charAt(i)-'a'] = 1;
                max = 1;
                continue;
            }
            
           int current = s.charAt(i) - 'a';
           int localMax = 0; 
           for(int j = 0; j <= k; j++){
               if(current + j <= 25){
                   localMax = Math.max(localMax,dp[current+j]);
               }
               if(current - j >= 0){
                   localMax = Math.max(localMax,dp[current-j]);
               }
           } 
            
           dp[current]= 1+localMax; 
           max = Math.max(max,dp[current]);
        }
        
        return max;
    }
    
    public int longestIdealString(int prevIndex,int currIndex,String s, int k,Integer[] dp) {
        if(currIndex == s.length()){
            return 0;
        }
        
        if(dp[currIndex] != null){
            return dp[currIndex];
        }
        
        int takeIt = 0;
        if(prevIndex == -1 || Math.abs(s.charAt(prevIndex)-s.charAt(currIndex))<= k)
           takeIt = 1 + longestIdealString(currIndex,currIndex+1,s,k,dp);
        
        int notTakeIt = longestIdealString(prevIndex,currIndex+1,s,k,dp);
        return Math.max(takeIt,notTakeIt);
    }
}