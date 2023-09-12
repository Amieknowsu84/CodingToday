class Solution {
    
    // [1,1,1,2,2,3]
    // index=4
    // current = 3    
    // cnt = 1
    // [1,1,2,2,3]    
    public int removeDuplicates(int[] nums) {
     
        int index = 0;
        int current = nums[0];
        int cnt=1;
        
        for(int i=1;i<nums.length;i++){
            if(current == nums[i]){
                if(cnt < 2){
                    nums[++index]=current;
                }
                cnt++;
            }else{
                cnt=1;
                current = nums[i];
                nums[++index]= current;
            }
        }
        
        return index+1;
        
        
    }
}