class Solution {
    
    // 11 1
    
    public String addBinary(String a, String b) {
        
        String reva = new StringBuilder(a).reverse().toString();
        String revb = new StringBuilder(b).reverse().toString();
        
        char carry='0';
        char sum='0';
        String res="";
        
        for(int i=0,j=0;i<Math.max(reva.length(),revb.length());i++,j++){
            char ca = (i<reva.length())?reva.charAt(i):'0';
            char cb = (j<revb.length())?revb.charAt(j):'0';   
            int cnt = getCount(ca,cb,carry);
            if(cnt == 3){
                sum = '1';
                carry = '1';
            }else if(cnt == 2){
                sum = '0';
                carry = '1';
            }else if(cnt == 1){
                 sum = '1';
                 carry = '0';
            }else{
                sum = '0';
                carry = '0';
            }
             
            res+=sum;
        }
        
        if(carry == '1'){
            res+=carry;
        }
        
        
        return new StringBuilder(res).reverse().toString();
        
        
    }
    
    int getCount(char ca,char cb,char carry){
         int cnt = 0;
         if(carry == '1'){
                cnt+=1;
         } 
        
         if(ca=='1' && cb=='1'){
             cnt+=2;
         }else if(ca=='1' || cb=='1'){
             cnt+=1;
         }
        
        return cnt;
    }
}