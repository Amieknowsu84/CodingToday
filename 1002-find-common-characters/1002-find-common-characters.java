class Solution {
    public List<String> commonChars(String[] words) {
       
        int[] orignalSet = new int[26];
        boolean firstWord = true;
        
        for(String word: words){
           
           int[] set = new int[26];
           for(int i = 0; i < word.length(); i++){
               set[word.charAt(i)-'a']++;
           }
            
           
           for(int i=0;i<26;i++){
               if(firstWord){
                   orignalSet[i] =  set[i];
               }else{
                  orignalSet[i]= Math.min( orignalSet[i], set[i]); 
               }
           }
           
          firstWord = false;
        }
        
        List<String> result = new ArrayList<>();
        
        for(int i=0;i<26;i++){
          char ch = (char)(i+'a');
          for(int j=0; j<orignalSet[i]; j++){
             result.add(ch+"");
          }
        }
       
        
        return result;   
    }
}