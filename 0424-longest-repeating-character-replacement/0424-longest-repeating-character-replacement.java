class Solution {
    public int characterReplacement(String s, int k) {
        
        int start = 0;
        int end = 0;
        int map[] = new int[26];
        int maxLen = 0;
        
        while(end < s.length()){
            map[s.charAt(end)-'A']++;
            int mostFrequentCharCount = Arrays.stream(map).max().orElse(0);
            int size = end-start+1;
            if(size - mostFrequentCharCount <= k){
                maxLen = Math.max(maxLen,size);
                end++;
            }else{
                map[s.charAt(start++)-'A']--;
                map[s.charAt(end)-'A']--;
            }
        }
        
        return maxLen;
    }
}