class Solution {
    public int[] rearrangeArray(int[] nums) {
        //[3,1,-2,-5,2,-4]
        int odd = 1;
        int even = 0;
        int[] res = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                res[odd] = nums[i];
                odd = odd+2;
            }else{
                res[even] = nums[i];
                even = even+2;
            }
        }
        
        return res;
    }
}