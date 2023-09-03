class Solution {
    
    //  0 1 2 3 4 5 6
    // [1,2,1,3,5,3,4]
    
   //  0 1
   // [1,2]
         
    
    // nums[i] != nums[i + 1] for all valid i.
    // how do we decide which side we move 
    // we can move to any side which has greater neighbour     
    
    public int findPeakElement(int[] nums) {
        
        if(nums.length == 1){
            return 0;
        }
        
         int low=0,high=nums.length-1;
        
         while(low<=high){
             
             int mid= low +(high-low)/2;
             if(mid==0 ){
                  if(nums[mid+1] < nums[mid])
                     return mid;
                  low=mid+1;
                  continue;
             }else if(mid == nums.length-1 ){
                 if(nums[mid-1] < nums[mid])
                     return mid;
                  high=mid-1;
                  continue;
             }else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                 return mid;
             }
             
             if(mid>0 && nums[mid] > nums[mid-1]){
                 low= mid+1;
             }else{
                 high = mid-1;
             }
         }
         
         return low;
    }
}