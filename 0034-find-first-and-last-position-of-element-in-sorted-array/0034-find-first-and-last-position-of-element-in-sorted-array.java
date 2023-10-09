class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        int result[] = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        while(low<=high){
            int mid = (high - low)/2 + low;
            if(nums[mid] == target){
                result[0] = mid;
            }
            if(nums[mid] >= target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        if(result[0] == -1){
            return result;
        }
        
        high = nums.length-1;
        low  = result[0];
       
        while(low<=high){
            int mid = (high - low)/2 + low;
            if(nums[mid] == target){
                result[1] = mid;
            }
            if(nums[mid] <= target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        
        return result;
        
        
    }
}