class Solution {
    
    //https://www.youtube.com/watch?v=z6LwIkEn9qc&ab_channel=codestorywithMIK
    //[1,3,5,2,7,5]
    //1
    //5
    
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minKpos = -1;
        int maxKpos = -1;
        int temp = 0;
        long cnt = 0;
        int culpritIndex = -1;
        
        for(int i=0; i < nums.length; i++){
            if(nums[i] == minK)
                minKpos = i;
             if(nums[i] == maxK)
                maxKpos = i;
             if(nums[i] > maxK || nums[i] < minK)
                culpritIndex = i;
            if(maxKpos!=-1 && minKpos!=-1){
                int smaller = Math.min(maxKpos,minKpos);
                int val = smaller - culpritIndex;
                cnt+=(val>=0?val:0);
            }   
        }
        
        return cnt;
        
    }
}