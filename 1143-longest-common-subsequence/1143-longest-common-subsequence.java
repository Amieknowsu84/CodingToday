class Solution {
   //   a c e
   // a 1 1 1
   // b 0 0 0
   // c 0 1 1
   // d 0 1 1 
   // e 0 1 2   
    public int longestCommonSubsequence(String text1, String text2) {
     
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length();j++){
        
                 if(i==0||j==0){
                    dp[i][j]=1;
                 }else if(text1.charAt(i-1)==text2.charAt(j-1)){
                     dp[i][j]=1+dp[i-1][j-1];
                 }else{
                     dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                 }
                
            }
        }
        
        return dp[text1.length()][text2.length()]-1;
        
        
    }
}