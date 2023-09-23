class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words,(a,b)->a.length()-b.length());
        
        int dp[]=new int[words.length];
        int max=0;
        
        for(int i=0;i<words.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(compare(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(dp[i],max);
        }
        
        return max;
        
    }
    
    public boolean compare(String word1,String word2){
        //bcd    //bc
        //bcda   //bad
        if(word1.length()!=word2.length()+1){
            return false;
        }
        
        int cnt=0;
        int i=0,j=0;
        while(j<word2.length()){
            if(word1.charAt(i) == word2.charAt(j)){
                i++;
                j++;
            }else{
                cnt++;
                if(cnt>=2){
                    return false;
                }
                i++;
            }   
        }
        
        return true;
        
    }
    
}