class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i=0, j = 0;
        int len = 0;
        int totalCost = 0;
        
        while(j < s.length()){
            totalCost += Math.abs(s.charAt(j)-t.charAt(j));
            //System.out.println(i+" "+j+" "+totalCost);
            if(totalCost <= maxCost){
                len = Math.max(len,j-i+1);
                j++;
            }else{
                 totalCost-=(Math.abs(s.charAt(i)-t.charAt(i)));
                 i++;
                 totalCost -= Math.abs(s.charAt(j)-t.charAt(j));
            }
        }
        
        return len;
        
    }
}