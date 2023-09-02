class Solution {
    Integer dp[];
    
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> stringSet = new HashSet<>();
        for(String word:dictionary){
            stringSet.add(word);
        }
        dp= new Integer[s.length()+1];
        dp[s.length()]=0;
        
        for(int i=s.length()-1;i>=0;i--){
            int min = s.length()-i;
            for(int j=i;j<s.length();j++){
               String substring= s.substring(i,j+1);
               if(stringSet.contains(substring)){
                   min=Math.min(min,dp[j+1]);
               }else{
                   min=Math.min(min,substring.length()+dp[j+1]);
               }
            }
            dp[i]=min;
            
        }
        
        return dp[0];
        
    }
    
    int solve(int index,String s,HashSet<String> stringSet){
        if(index >= s.length()){
            return 0;
        }
        
        if(dp[index]!=null){
            return dp[index];
        }
        
        int min=s.length();
        
        for(int i=index;i<s.length();i++){
            String left = s.substring(index,i+1);
            if(stringSet.contains(left)){
                min=Math.min(min,0+solve(i+1,s,stringSet));
            }else{
                min=Math.min(min,left.length()+solve(i+1,s,stringSet));
            }
        }
        
        return dp[index]=min;
    }
}