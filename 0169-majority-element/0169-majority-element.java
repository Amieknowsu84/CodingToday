class Solution {
    public int majorityElement(int[] nums) {
  
        int cnt=1;
        int majorityElement = nums[0];
        
        //moore algorithm
        for(int i=1;i<nums.length;i++){
           if(nums[i] == majorityElement){
                cnt++;
           }else{
                cnt--;
           }
            
           if(cnt == 0){
               majorityElement = nums[i];
               cnt = 1;
           } 
        }
        
        return majorityElement;
        
    }
}