class Solution {
    public long distinctNames(String[] ideas) {
        
        HashMap<Character,Set<String>> map = new HashMap<>();
        
        for(String word:ideas){
            Set<String> words = map.getOrDefault(word.charAt(0),new HashSet<>());
            words.add(word.substring(1,word.length()));
            map.put(word.charAt(0),words);
        }
        
        List<Character> characters = map.keySet().stream().collect(Collectors.toList());
        long sum = 0;
        
        for(int i=0;i<characters.size();i++){
            for(int j=i+1;j<characters.size();j++){
                Set<String> words1 =  map.get(characters.get(i));
                Set<String> words2 =  map.get(characters.get(j));
                
                
                int noOfDistinctInWords2 = findDistinct(words1,words2);
                int noOfNonDistinctWord = words2.size() - noOfDistinctInWords2;
                int numOfDistinctInWords1 = words1.size() - noOfNonDistinctWord;
                
                // 2 bcz tmp+imp imp+tmp
                sum+= 2* numOfDistinctInWords1*noOfDistinctInWords2;
            }
        }
        
        return sum;
        
    }
    
    int findDistinct(Set<String> words1,Set<String> words2){
        int cnt = 0;
        
        for(String word:words2){
            if(!words1.contains(word))
                cnt++;
        }
        
        return cnt;
    }
}