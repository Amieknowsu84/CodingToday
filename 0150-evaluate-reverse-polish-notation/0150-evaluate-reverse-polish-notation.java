class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if(isInteger(tokens[i])){
              stack.push(Integer.parseInt(tokens[i]));
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                int value = operate(tokens[i],num2,num1);
                //System.out.println(num1+" "+num2+" "+value);
                stack.push(value);
            }
        }
        return stack.peek();
    }
    
    boolean isInteger(String token){
        return Character.isDigit(token.charAt(0))||
            token.length()>1 && Character.isDigit(token.charAt(1));
    }
    
    int operate(String token,int num1,int num2){
        if(token.equals("+")){
            return num1 + num2;
        }else if(token.equals("-")){
            return num1 - num2;
        }else if(token.equals("*")){
            return num1 * num2;
        }else if(token.equals("/")){
            return num1 / num2;
        }else{
            return 0;
        }
    }
}