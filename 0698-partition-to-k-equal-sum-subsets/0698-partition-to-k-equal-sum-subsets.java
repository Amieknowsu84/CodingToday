class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        
        int target = sum / k;
        Arrays.sort(nums);
        int[] subsetSums = new int[k];
        
        return backtrack(nums, subsetSums, nums.length - 1, target);
    }
    
    boolean backtrack(int[] nums, int[] subsetSums, int index, int target) {
        if (index < 0) {
            for (int sum : subsetSums) {
                if (sum != target) {
                    return false;
                }
            }
            return true;
        }
        
        int num = nums[index];
        for (int i = 0; i < subsetSums.length; i++) {
            if (subsetSums[i] + num <= target) {
                subsetSums[i] += num;
                if (backtrack(nums, subsetSums, index - 1, target)) {
                    return true;
                }
                subsetSums[i] -= num; 
            }
            
            if (subsetSums[i] == 0) {
                break; 
            }
        }
        
        return false;
    }
}
