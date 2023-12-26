class Solution {
    
    List<String> result;
    
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(new StringBuilder(),1,1,n);
        return result;
    }
    
    void generate(StringBuilder temp,int ob,int cb,int n){
        if(ob+cb == 2*n+2){
            result.add(temp.toString());
            return;
        }
        if(ob+cb > 2*n+2){
            return; 
        }
        
        if(ob <= n){
            temp.append("(");
            generate(temp,ob+1,cb,n);
            temp.deleteCharAt(temp.length()-1);
        }
        if(!temp.equals("") && cb<ob){
            temp.append(")");
            generate(temp,ob,cb+1,n);
            temp.deleteCharAt(temp.length()-1);
        }
        
    }
}