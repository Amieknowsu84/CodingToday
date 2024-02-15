class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long res = -1, cumulative = 0;
        
        for (int i = 0; i < nums.length; i++){
            if(cumulative > nums[i]){
               cumulative+=nums[i];
               res = cumulative; 
            }else{
               cumulative+=nums[i];   
            }
        }
            
        return res;
    }
}