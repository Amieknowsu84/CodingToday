class Solution {
    
    //[1,3,4,8,7,9,3,5,1] k = 2
    public int[][] divideArray(int[] nums, int k) {
        
         if(nums.length % 3 != 0){
           return new int[][]{};   
         }
        
        int[][] result = new int[nums.length/3][3];
        int ind = 0;
        
       
        // 1 1 3 3 4 5 7 9
        Arrays.sort(nums);
        // 1 2 3 3 3 7
        
        for(int i=0; i<nums.length; i+=3){
            if(nums[i+2]-nums[i] <= k){
                int[] sub= new int[3];
                sub[0] = nums[i];
                sub[1] = nums[i+1];
                sub[2] = nums[i+2];
                result[ind++] = sub;
            }else{
                return new int[][]{};
            }
        }
        
        return result;
        
    }
}