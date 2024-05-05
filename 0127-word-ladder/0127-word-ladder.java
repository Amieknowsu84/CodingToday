class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int level = 1;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i=0;i < size; i++){
              String current = queue.remove();
              words.remove(current);  
                
              if(current.equals(endWord)){
                return level;
              }
                
              for(String word: words){
                  if(!visited.contains(word) && isNextDistance(current,word)){
                     queue.add(word);
                     visited.add(word);
                 }
              } 
                 
            } 
            level++;
        }
        
        return 0;
    }
    
    
    boolean isNextDistance(String a,String b){
        int cnt = 0;
        for(int i=0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
            if(cnt > 1){
                return false;
            }
        }
        return cnt!=0;
    }
    
}