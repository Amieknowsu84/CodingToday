class Solution {
    
    //[1,3,4,8,7,9,3,5,1] k = 2
    public int[][] divideArray(int[] nums, int k) {
         if(nums.length % 3 != 0){
           return new int[][]{};   
         }
        
        int[][] result = new int[nums.length/3][3];
        int ind = 0;
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i+=3){
            if(nums[i+2]-nums[i] <= k){
                int[] sub= new int[]{nums[i],nums[i+1],nums[i+2]};
                result[ind++] = sub;
            }else{
                return new int[][]{};
            }
        }
        
        return result;
    }
}