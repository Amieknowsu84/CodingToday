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
        
      HashMap<Character,Integer> map = new HashMap<>();
      for(int i=0;i<word.length();i++){
          map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
      }
        
       return map.entrySet().stream()
        .allMatch(entry -> orignal[entry.getKey() - 'a'] >= entry.getValue());

    
    }
}