class Solution {
    public String reorganizeString(String s) {
      char prev='-';
      int count[]=new int[26];
        
      for(char character:s.toCharArray()){
          count[character-'a']++;
      }
        
      PriorityQueue<Character> queue=
          new PriorityQueue<>( (a,b)->
          count[b-'a']-count[a-'a']);
        
      for(int i=0;i<26;i++){
          if(count[i]!=0){
              queue.add((char)('a'+i));
          }
      }  
        
      String res="";
      int index=0;
        
      while(!queue.isEmpty()){
          char character= queue.remove();
          count[character-'a']--;
          
          if(index>0 && res.charAt(index-1)==character){
            return "";
          }
          res+=character;
          //System.out.println(character+" "+prev+" "+res);
          if(prev!='-' && count[prev-'a']>0){
              queue.add(prev);
          }
          prev=character;
          //System.out.println(character+" "+prev+" "+res+queue);
          index++;
      }
        
      return  count[prev-'a']>0?"":res;  
    }
}