class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int abs = Math.abs(nums[i]);
            int index = abs-1;
            if(nums[index] < 0){
               return abs;
            }else{
                nums[index] = -nums[index];
            }
        }
        return -1;
    }
}