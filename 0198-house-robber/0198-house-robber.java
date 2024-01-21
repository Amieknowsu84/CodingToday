class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return rob(nums.length-1,nums,dp);
    }
    
    public int rob(int index,int[] nums,Integer[] dp) {
       if(index == 0){
           return nums[index];
       }
       if(index < 0){
           return 0;
       }
       if(dp[index] != null){
           return dp[index];
       } 
        
       int notConsider = rob(index-1,nums,dp);
       int consider = nums[index] + rob(index-2,nums,dp);
       return dp[index] = Math.max(consider,notConsider); 
    }
    
}