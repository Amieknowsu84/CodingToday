class Solution {
    public int countSubstrings(String s) {
        int cnt = s.length();
        
        for(int len=2;len<=s.length();len++){
            for(int j=0; j<s.length(); j++){
                if(j+len<=s.length()){
                   String sub = s.substring(j,j+len);
                  //  System.out.println(sub);
                   if(isPalindorme(sub)){
                       cnt++;
                   } 
                }
            }
        }
        return cnt;
    }
    
    boolean isPalindorme(String data){
        int i=0,j=data.length()-1;
        while(i<j){
            if(data.charAt(i) != data.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}