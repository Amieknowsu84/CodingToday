class Solution {
   public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<int[]> convertedNums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            convertedNums.add(new int[]{convert(nums[i], mapping), nums[i]});
        }

        Collections.sort(convertedNums, (a, b) -> a[0] == b[0] ? 0 : a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            nums[i] = convertedNums.get(i)[1];
        }

        return nums;
    }
    
    int convert(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }

        int newNum = 0;
        int place = 1;
        
        while (num > 0) {
            int digit = num % 10;
            newNum = mapping[digit] * place + newNum;
            place *= 10;
            num /= 10;
        }
        
        return newNum;
    }
}