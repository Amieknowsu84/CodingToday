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
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k){
                
                if(j != i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        return list;
        
    }
}