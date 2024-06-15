class Solution {
     public boolean checkValidString(String s) {
        int n = s.length();
        int openCount = 0;
        int closeCount = 0;
         
        // "(((*))"
         
        for(int i=0; i < n; i++){
           if(s.charAt(i) == ')'){
               openCount--;
           }else{
               openCount++;
           }
            
           if(openCount < 0){
               return false;
           } 
            
        }
         
         for(int i=n-1; i >= 0; i--){
           if(s.charAt(i) == '('){
               closeCount--;
           }else{
               closeCount++;
           }
            
           if(closeCount < 0){
               return false;
           } 
            
        }
         
         
        return true; 
         
    }
}