class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return countBeautifulSubsets(nums, k, nums.length - 1, new HashMap<>());
    }

    private int countBeautifulSubsets(int[] nums, int k, int index, Map<Integer, Integer> map) {
        if (index < 0) {
            return map.isEmpty() ? 0 : 1;
        }

        int take = 0;
        int notTake = countBeautifulSubsets(nums, k, index - 1, map);

        if (!map.containsKey(nums[index] - k) && !map.containsKey(nums[index] + k)) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            take = countBeautifulSubsets(nums, k, index - 1, map);
            if (map.get(nums[index]) == 1) {
                map.remove(nums[index]);
            } else {
                map.put(nums[index], map.get(nums[index]) - 1);
            }
        }

        return take + notTake;
    }
}
