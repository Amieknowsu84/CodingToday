class Solution {
//      0 1 2 3
//     [10,5,2,6]
         
//     left 0
//     right 3
//     product = 50  k=100
         
//     [2]
    // crux of algo
    // j-i+1 gives all the subarray ending at j
    //[10,5,100,6] i=2 j=3  2 subarray ending at 6  [2,6] [6]
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt=0;
        long product = 1;
        int left = 0;
        int right = 0;
        
        while(right < nums.length){
            product *= nums[right];
            
            while(product >= k && left <= right){
                product/=nums[left];
                left++;
            }
            
            cnt+= (right-left+1);
            right++;
        }
        
        return cnt;         
    }
}