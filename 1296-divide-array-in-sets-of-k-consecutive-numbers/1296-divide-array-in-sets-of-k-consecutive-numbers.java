class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
         int n = nums.length;
        if (n % k != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Arrays.sort(nums);
        for (int a : nums) {
            if (map.get(a) > 0) {
                for (int i = 0; i < k; i++) {
                    if (!map.containsKey(a + i) || map.get(a + i) == 0) {
                        return false;
                    } else {
                        map.put(a + i, map.get(a + i) - 1);
                    }
                }
            }
        }
        return true;
    }
}