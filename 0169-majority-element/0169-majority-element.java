class Solution {
    public int majorityElement(int[] nums) {
  
        int count1=0;
        Integer majority1=null;
        
        //moore algorithm
        for(int i=0;i<nums.length;i++){
            if(majority1!=null && nums[i] == majority1){
                count1++;
            }else if(count1 == 0){
                majority1=nums[i];
                count1=1;
            }else{
                count1--;
            }
        }
        
        return majority1;
        
    }
}