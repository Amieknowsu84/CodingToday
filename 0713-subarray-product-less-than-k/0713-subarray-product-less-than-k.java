class Solution {
//      0 1 2 3
//     [10,5,2,6]
         
//     left 0
//     right 3
//     product = 50  k=100
         
//     [2]     
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt=0;
        long product = 1;
        int left = 0;
        for(int right=0;right<nums.length;right++){
            product*=nums[right];
            while(product>=k && left<=right){
               product/=nums[left];
               left++;
            }
            
            cnt+=(right-left+1);
        }
        
        return cnt;         
    }
}