class Solution {
    public int characterReplacement(String s, int k) {
        
        int start = 0;
        int end = 0;
        int map[] = new int[26];
        int maxLen = 0;
        
        while(end < s.length()){
            int mostFrequentCharCount = Arrays.stream(map).max().orElse(0);
            int size = end-start;
            if(size - mostFrequentCharCount <= k){
                map[s.charAt(end++)-'A']++;
                size = end - start;
                mostFrequentCharCount = Arrays.stream(map).max().orElse(0);
                if(size - mostFrequentCharCount <= k)
                  maxLen = Math.max(maxLen,end-start);
            }else{
                map[s.charAt(start++)-'A']--;
            }
        }
        
        return maxLen;
    }
}