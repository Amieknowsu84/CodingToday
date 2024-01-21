class Solution {
    public int rob(int[] nums) {
         if(nums.length == 1){
            return nums[0];
        }
        
        List<Integer> list1 = sliceArrayToList(nums,0,nums.length-1);
        List<Integer> list2 = sliceArrayToList(nums,1,nums.length);
        return Math.max(rob(list1),rob(list2));
        
    }
    
      public int rob(List<Integer> nums) {
        if(nums.size() == 1){
            return nums.get(0);
        }
        int[] dp = new int[3];
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(1),nums.get(0));
        dp[2] = Math.max(dp[0],dp[1]); 
        
        for(int i=2; i<nums.size(); i++){
            int prev = dp[1];
            dp[2] = Math.max(dp[1],nums.get(i)+dp[0]);
            dp[1] = dp[2];
            dp[0] = prev;
        }
        return dp[2];
    }
    
    public static List<Integer> sliceArrayToList(int[] array, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > array.length || startIndex > endIndex) {
            throw new IllegalArgumentException("Invalid indices");
        }

        int[] slicedArray = Arrays.copyOfRange(array, startIndex, endIndex);

        List<Integer> resultList = new ArrayList<>();
        for (int value : slicedArray) {
            resultList.add(value);
        }

        return resultList;
    }
    
}