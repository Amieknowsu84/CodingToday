class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cntOne = 0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                cntOne++;
            }
        }
        
        String zero = "0";
        String one = "1";
        
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length()-1; i++){
            if(cntOne > 1){
              result.append(one);
              cntOne--;
            }else{
              result.append(zero);   
            }
        }
        result.append(one);
        
        return result.toString();
    }
}