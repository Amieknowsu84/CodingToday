class Solution {
    
    List<String> result;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordDict);
        generateSentence(s,words,0,new StringBuilder(),0);
        return result;
    }
    
    void generateSentence(String s, Set<String> wordDict,int index,StringBuilder sb,int cnt){
       if(index >= s.length()){
           //System.out.println(cnt+" " +sb.length()+" "+s.length());
           if(sb.length() == s.length() + cnt-1){
               result.add(sb.toString());
           }
           return;
       }
       
       StringBuilder orignal = new StringBuilder(sb.toString());
        
       for(int i=index; i<s.length();i++){
          String word = s.substring(index, i+1);
          if(wordDict.contains(word)){
              if(sb.length() != 0)
                  sb.append(" "+word);
              else
                  sb.append(word);
              generateSentence(s,wordDict,i+1,sb,cnt+1);
              sb = new StringBuilder(orignal);
          } 
       }
        
    }
    
    
}