class Solution {
    Integer dp[];
    
    public int minExtraChar(String s, String[] dictionary) {
        
        HashSet<String> stringSet = new HashSet<>();
        
        for(String word:dictionary){
            stringSet.add(word);
        }
        
        dp = new Integer[s.length()+1];
        dp[s.length()] = 0;
        
        for(int i=s.length()-1;i>=0;i--){
            
            int min = s.length()-i;
            String current= "";
            
            for(int j=i;j<s.length();j++){
               current += s.charAt(j);
               if(stringSet.contains(current)){
                   min=Math.min(min,dp[j+1]);
               }else{
                   min=Math.min(min,current.length()+dp[j+1]);
               }
            }
            
            dp[i]=min;
        }
        
        return dp[0];
        
    }
    
   
}