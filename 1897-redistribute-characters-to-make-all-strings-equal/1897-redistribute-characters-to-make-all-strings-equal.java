class Solution {

    
    public boolean makeEqual(String[] words) {
        if(words.length <=1)
            return true;
        
        int[] map = new int[26];
        
        for(String word:words){
           for(char character:word.toCharArray()){
               map[character-'a']++;
           }    
        }

        return Arrays.stream(map).allMatch(elem->elem == 0|| elem % words.length == 0);
        
    }
}