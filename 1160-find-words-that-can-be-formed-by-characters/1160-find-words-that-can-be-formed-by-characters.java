class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int orignal[] = new int[26];
        
        for(int i=0; i<chars.length(); i++){
            orignal[chars.charAt(i)-'a']++;
        }
        
        return Arrays.stream(words)
               .map((word)->canBeTaken(word,orignal)?word.length():0)
               .reduce(0,Integer::sum);
    }
    
    boolean canBeTaken(String word,int[] orignal){
        
      int[] wordFreq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            wordFreq[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] > orignal[i]) {
                return false;
            }
        }

        return true;
    
    }
}