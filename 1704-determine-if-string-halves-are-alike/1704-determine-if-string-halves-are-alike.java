class Solution {

    
    public boolean halvesAreAlike(String s) {
        int cnt = 0;
        int mid = s.length()/2;
        
        for(int i=0; i<s.length(); i++){
            if(i>=mid){
              if(isVowel(s.charAt(i)) ){
                 cnt++;
              }  
            }else{
                if(isVowel(s.charAt(i)) ){
                   cnt--;  
                }  
            }
        }
        
  
        return cnt==0;

    }
    
    boolean isVowel(char c){
        return c == 'a' || c == 'e'|| c=='i'|| c=='o' || c == 'u'
          ||    c == 'A' || c == 'E'|| c=='I'|| c=='O' || c == 'U';
    }
    
   
}