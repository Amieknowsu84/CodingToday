class Solution {
    
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length();i++){
            if(!stack.isEmpty() && check(stack.peek(),s.charAt(i))){
                stack.pop();
            }else{
                stack.add(s.charAt(i));
            }
        }
        
      StringBuilder result = new StringBuilder();
      while(!stack.isEmpty()){
          result.append(stack.pop());
      }
        
      return result.reverse().toString();  
    }
    
    boolean check(char a,char b){
        if(Character.isUpperCase(a) && Character.isLowerCase(b)
          ||Character.isUpperCase(b) && Character.isLowerCase(a) ){
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        }
        return false;
    }
}