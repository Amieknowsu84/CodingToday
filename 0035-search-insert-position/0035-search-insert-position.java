class Solution {
    
    // why return left [2]  try finding target 0,3
    // target=0 for l=0 r=0 m=0 , r=mid-1 but left = 0 itself we return 0 correct position to insert
    // target=3 for l=0 r=0 m=0 , l=mid+1 but left = 1 itself we return 1 correct position to insert
    
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid]== target){
              return mid;
            }
            
            if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
       return low;
        
    }
}