class Solution {
     public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> astrikStack = new Stack<>(); 
         
        // "(((*))"
         
        for(int i=0; i < n; i++){
            if(s.charAt(i) == '('){
                openBracket.push(i);
            }else if(s.charAt(i) == ')'){
                 if(!openBracket.isEmpty()){
                     openBracket.pop();
                 }else if(!astrikStack.isEmpty()){
                     astrikStack.pop();
                 }else{
                     return false;
                 }
            }else{
                astrikStack.push(i);
            }
        }
         
         
         
        while(!openBracket.isEmpty() && !astrikStack.isEmpty()){
            //System.out.println(astrikStack.peek()+" "+openBracket.peek());
            if(astrikStack.peek() < openBracket.peek()){
                return false;
            }
            astrikStack.pop();
            openBracket.pop();
        }
         
        return openBracket.isEmpty(); 
         
    }
}