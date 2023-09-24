class Solution {
    
    // 11 1
    
    public String addBinary(String a, String b) {
        
        
        char carry='0';
        char sum='0';
        String res="";
    
        for(int i=a.length()-1,j=b.length()-1; (i>=0||j>=0); i--,j--){
            char ca = (i>=0)?a.charAt(i):'0';
            char cb = (j>=0)?b.charAt(j):'0';   
            int cnt = (ca-'0')+(cb-'0')+(carry-'0');
            sum = '0';
            carry = '0';
            if(cnt % 2 != 0){
                sum = '1';
            }
            if(cnt == 3 || cnt == 2){
                carry = '1';
            }   
            res=sum+res;
        }
        
        if(carry == '1'){
            res=carry+res;
        }
        
        return res;
    }
    
}