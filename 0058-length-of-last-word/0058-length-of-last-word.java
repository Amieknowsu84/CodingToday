class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length()-1;
        int cnt = 0;
        
        while(s.charAt(j) == ' '){
            j--;
        }
        
        while(j >= 0){
            if(s.charAt(j) == ' '){
                break;
            }
            cnt++;
            j--;
        }
        
        return cnt;
    }
}