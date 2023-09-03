class Solution {
     // 0 1 2 3 4 5 6
    // 7,0,1,2,4,5,6
    
    public int findMin(int[] nums) {
        
        int low=0,high=nums.length-1;
        int ans=Integer.MAX_VALUE;   
        
        
        while(low<=high){
            
            //if the array itself is sorted then low one is the minimum 
            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }
            
            int mid=low +(high-low)/2;
        
            //one half will be always sorted.
            //minimum element will always lie in unsorted half.
            // also before moving to unsorted part we need to check for minimum of sorted part
            
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