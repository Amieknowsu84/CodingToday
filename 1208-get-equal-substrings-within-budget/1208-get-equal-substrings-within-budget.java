class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i=0, j = 0;
        int len = 0;
        int totalCost = 0,cost = 0;
        
        while(j < s.length()){
            cost = Math.abs(s.charAt(j)-t.charAt(j));
            if(maxCost - cost >= 0){
                maxCost -= cost; 
                len = Math.max(len,j-i+1);
                j++;
            }else{
                 maxCost += (Math.abs(s.charAt(i)-t.charAt(i)));
                 i++;
            }
        }
        
        return len;
        
    }
}