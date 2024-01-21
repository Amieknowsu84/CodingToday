class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        Integer[] dp = new Integer[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]); 
        }
        return dp[nums.length-1];
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