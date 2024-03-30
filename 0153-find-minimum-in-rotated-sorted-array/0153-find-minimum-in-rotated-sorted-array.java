class Solution {
     // 0 1 2 3 4 5 6
    // 7,0,1,2,4,5,6
    
    public int findMin(int[] nums) {
        
        int low=0,high=nums.length-1;
        int ans=Integer.MAX_VALUE;  
        
        //if the array itself is sorted then low one is the minimum 
        if(nums[low]<=nums[high]){
            return nums[low];
        }
        
        
        while(low<=high){
            
            int mid=low +(high-low)/2;
        
            //one half will be always sorted.
            //minimum element can lie in unsorted half or unsorted half.
            //so before moving to unsorted part we need to check for minimum of sorted part
            if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low = mid+1;
            }else{
                ans=Math.min(ans,nums[mid]);
                high = mid-1;
            }
               
        }
        
        return ans;
        
        
    }
}