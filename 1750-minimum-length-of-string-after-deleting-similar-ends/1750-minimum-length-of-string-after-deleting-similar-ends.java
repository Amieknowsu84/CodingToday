class Solution {
    public int minimumLength(String s) {
    
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            char current = s.charAt(left);
            if(s.charAt(left) == s.charAt(right)){
                while(left<s.length() && s.charAt(left) == current)
                    left++;
                while(right>=0 && s.charAt(right) == current)
                    right--;
            }else{
                break;
            }
        }
        
        if(left>right){
            return 0;
        }else if(left == right){
            return 1;
        }else{
            return right-left+1;
        }
    }
}