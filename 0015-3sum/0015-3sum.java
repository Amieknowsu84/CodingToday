class Solution {
       // 0  1 2 3  4  5
   // [-1,0,1,2,-1,-4]
   //.[-4,-1,-1,0,1,2] 
           
    // num1  =  0
    // left  =  4
    // right =  5   
    
    //[0,0,0,0,0]

    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            
            int num1 = nums[i];   
            int left = i+1;
            int right = nums.length-1;
            
            while(left < right){
                
                int threeSum = num1 + nums[left] + nums[right];
                if(threeSum < 0){
                    left++;
                }else if(threeSum > 0){
                    right--;
                }else{
                    result.add(Arrays.asList(num1,nums[left],nums[right]));
                    left++;
                    while(left<nums.length && nums[left]==nums[left-1])
                        left++;
                }
                
            }
        }
        
        return result;
        
        
    }
}