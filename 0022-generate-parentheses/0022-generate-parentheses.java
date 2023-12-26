class Solution {
    
    List<String> result;
    
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(new StringBuilder(),0,0,n);
        return result;
    }
    
    void generate(StringBuilder temp,int openBracket,int closedBracket,int n){
        if(openBracket+closedBracket == 2*n){
            result.add(temp.toString());
            return;
        }
        
        if(openBracket < n){
            temp.append("(");
            generate(temp,openBracket+1,closedBracket,n);
            temp.deleteCharAt(temp.length()-1);
        }
        if(!temp.equals("") && closedBracket<openBracket){
            temp.append(")");
            generate(temp,openBracket,closedBracket+1,n);
            temp.deleteCharAt(temp.length()-1);
        }
        
    }
}