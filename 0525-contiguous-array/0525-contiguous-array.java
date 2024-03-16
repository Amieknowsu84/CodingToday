class Solution {

   
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,-1);
        int max_length = 0;
        int count = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) 
                count += -1;
            else 
               count += 1;
            
            
            if (hs.containsKey(count)) {
                max_length = Math.max(max_length,i-hs.get(count));
            }
           else
               hs.put(count,i);
        }
    
        return max_length;
   
    }           
}