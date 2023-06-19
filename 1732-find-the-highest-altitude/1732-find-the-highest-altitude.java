class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int curr=0;
        for(int diff:gain){
            curr+=diff;
            max=Math.max(curr,max);
        }
        return max;
    }
}