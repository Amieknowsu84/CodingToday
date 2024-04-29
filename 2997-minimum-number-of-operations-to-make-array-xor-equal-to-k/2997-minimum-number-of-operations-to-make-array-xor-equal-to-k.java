class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        
        for(int num: nums){
           xor ^= num;   
        }
        
        int cnt = 0;    
        xor = xor ^ k;
        
        while(xor > 0){
            int lastBit = xor & 1;
            if(lastBit == 1){
                cnt++;
            }
            xor = xor >> 1;
        }
        
        return cnt;
    }
}