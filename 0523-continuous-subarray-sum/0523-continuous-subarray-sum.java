class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store the remainder and the corresponding index
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);  // To handle the case when the subarray starts from index 0
        
        long sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = (int) (sum % k);
            
            // Handling negative remainders to ensure correct modulus operation
            if (remainder < 0) {
                remainder += k;
            }
            
            if (remainderMap.containsKey(remainder)) {
                int prevIndex = remainderMap.get(remainder);
                // Check if the subarray length is at least 2
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
        return false;
    }
}
