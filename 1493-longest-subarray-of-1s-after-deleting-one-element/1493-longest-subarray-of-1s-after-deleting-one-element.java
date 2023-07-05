class Solution {
    public int longestSubarray(int[] nums) {
        
        int max=0;
        int curr=0;
        int prev=0;
        boolean canDelete=false;
        boolean foundZero=false;
     
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                curr++;
            }else{
                foundZero=true;
                if(canDelete){
                    max=Math.max(max,curr+prev);
                }else{
                    max=Math.max(max,curr);
                }
                
                if(i-1>=0 && nums[i-1]==1 && i+1<nums.length && nums[i+1]==1){
                    canDelete=true;
                }else{
                    canDelete=false;
                }
                prev=curr;
                curr=0;
            }
        }
        if(!foundZero){
            return nums.length-1;
        }
        return canDelete?Math.max(max,prev+curr):Math.max(max,curr);
    }
}