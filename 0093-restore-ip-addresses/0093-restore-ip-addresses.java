class Solution {
    
   List<String> result;
    
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        solve(s,0,new LinkedList<String>());
        return result;
        
    }

    
    void solve(String s,int start,LinkedList<String> list){
        
        if(list.size() > 4){
            return;
        }
        
        if(start == s.length() && list.size() == 4){
            result.add(String.join(".", list));
        }
        
        
        
        for(int i=start;i<s.length();i++){
            
            String substring=s.substring(start,i+1);
            
            if(isValid(substring)){
                list.add(substring);
                solve(s,i+1,list);
                list.removeLast();
            }
            
        }
    }
    
    boolean isValid(String s){
        
        if(s.length() > 3){
            return false;
        }
        if(s.charAt(0)=='0'){
            return s.length() == 1;
        }
        if(s.length()==3){
          int num=Integer.parseInt(s);
          return num<=255;
        }
        return true;
    }
    
}