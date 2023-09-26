class Solution {
    //[c,]
//     "cbacdcbc"
//      [c]
//      a 1
//      b 2
//      c 3
//      d 1  
    
   // bbcaac
      //[b]  
   //"abacb"
   // [a,b,a]
        
    public String removeDuplicateLetters(String s) {
      int[] map = new int[26];  
      for(int i=0;i<s.length();i++){
         map[s.charAt(i)-'a']++;
      }  
        
      Stack<Character> st = new Stack<>();
      HashSet<Character> used = new HashSet<>();  
      
      for(int i=0; i<s.length(); i++){
          while(!st.isEmpty() && map[st.peek()-'a']>=1 && st.peek()>=s.charAt(i) && !used.contains(s.charAt(i))){
              used.remove(st.peek()); 
              st.pop();
          }
         
          if(!used.contains(s.charAt(i))){
            used.add(s.charAt(i));  
            st.push(s.charAt(i));
          }    
          map[s.charAt(i)-'a']--;
      }  
        
       StringBuilder result = new StringBuilder();
       while (!st.isEmpty()) {
            result.append(st.pop());
       }
       return result.reverse().toString();
         
    }
}