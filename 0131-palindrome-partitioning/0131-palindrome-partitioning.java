class Solution {
    
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        solve(s,0,new LinkedList<String>());
        return result;
    }
    
    
    void solve(String s,int start,LinkedList<String> list){
        
        if(start==s.length()){
            result.add(new ArrayList<>(list));
        }
        
        for(int i=start;i<s.length();i++){
            
            String substring=s.substring(start,i+1);
            
            if(isPalindrome(substring)){
                list.add(substring);
                solve(s,i+1,list);
                list.removeLast();
            }
            
        }
    }
    
    boolean isPalindrome(String s){
        if(s.length()<=1){
            return true;
        }
        int start=0,end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    
    
}