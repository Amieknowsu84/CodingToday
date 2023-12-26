class Solution {
    
    List<String> result;
    
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate("",1,1,n);
        return result;
    }
    
    void generate(String temp,int ob,int cb,int n){
        if(ob+cb == 2*n+2){
            result.add(temp);
            return;
        }
        if(ob+cb > 2*n+2){
            return; 
        }
        
        if(ob <= n){
            generate(temp+"(",ob+1,cb,n);
        }
        if(!temp.equals("") && cb<ob){
            generate(temp+")",ob,cb+1,n);
        }
        
    }
}