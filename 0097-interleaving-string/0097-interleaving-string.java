class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];  
      return isInterleave(0,0,s1,s2,s3,dp);   
    }
    
    boolean isInterleave(int i,int j,String s1, String s2, String s3,Boolean[][] dp){
        
        if(i == s1.length() && j == s2.length() && i+j == s3.length()){
             return true;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        boolean result = false;
        
        if(i< s1.length() && i+j < s3.length() && s1.charAt(i) == s3.charAt(i+j))
            result = result || isInterleave(i+1,j,s1,s2,s3,dp);
        if(j< s2.length() && i+j < s3.length() && s2.charAt(j) == s3.charAt(i+j))
            result = result || isInterleave(i,j+1,s1,s2,s3,dp);
        
        return dp[i][j] = result;
    }
}