class Solution {
    public int longestConsecutive(int[] nums) {
        // Create a set to store all numbers in the array
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLen = 0; // Initialize the maximum length of consecutive sequence
        
        // Iterate through each number in the set
        for (int num : set) {
            int cnt = 0; // Initialize count for consecutive sequence
            int current = num; // Initialize current number for sequence
            
            // If the current number is already part of a sequence (i.e., it's not the start of a new sequence), skip it
            if (set.contains(current - 1)) {
                continue;
            }
            
            // Start counting from the current number until there are consecutive numbers in the set
            while (set.contains(current)) {
                current += 1;
                cnt++;
            }
            
            // Update the maximum length if the current sequence length is greater
            if (cnt > maxLen) {
                maxLen = cnt;
            }
        }
        
        return maxLen; // Return the maximum length of consecutive sequence
    }
}
