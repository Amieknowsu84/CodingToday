class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return beautifulSubsets(nums, k, nums.length-1,new HashMap<>());
    }
    
    int beautifulSubsets(int[] nums, int k, int index,Map<Integer,Integer> map) {
        if(index < 0){
            if(!map.isEmpty()){
                return 1;
            }else{
                return 0;
            }
        }
        
        int take = 0;
        int notTake = 0;
    
        if(!map.containsKey(nums[index] - k) && !map.containsKey(k + nums[index])){
            map.put(nums[index],map.getOrDefault(nums[index],0)+1);
            
            take = beautifulSubsets(nums,k,index-1,map);
            
            if(map.get(nums[index]) == 1){
              map.remove(nums[index]);
            }else{
               map.put(nums[index],map.getOrDefault(nums[index],0)-1);  
            }
        }
        
        notTake = beautifulSubsets(nums,k,index-1,map);
        
        return take + notTake;
    }
}