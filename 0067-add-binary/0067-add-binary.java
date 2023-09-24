class Solution {
    
    // 11 1
    
    public String addBinary(String a, String b) {
        
        
        char carry='0';
        char sum='0';
        String res="";
    
        for(int i=a.length()-1,j=b.length()-1; (i>=0||j>=0); i--,j--){
            char ca = (i>=0)?a.charAt(i):'0';
            char cb = (j>=0)?b.charAt(j):'0';   
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
            res=sum+res;
        }
        
        if(carry == '1'){
            res=carry+res;
        }
        
        
        return res;
        
        
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