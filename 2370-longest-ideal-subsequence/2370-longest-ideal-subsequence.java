class Solution {
    public int longestIdealString(String s, int k) {
        // Initialize an array to store counts of characters
        int[] dp = new int[26];
        int max = 0;
        
        // Traverse the string in reverse order
        for (int i = 0; i < s.length(); i++) {
            // Convert character to index
            int current = s.charAt(i) - 'a';
            int localMax = 0;
            
            // Check characters within distance k
            for (int j = 0; j <= k; j++) {
                if (current + j < 26) localMax = Math.max(localMax, dp[current + j]);
                if (current - j >= 0) localMax = Math.max(localMax, dp[current - j]);
            }
            
            // Update count for current character
            dp[current] = 1 + localMax; 
            max = Math.max(max, dp[current]);
        }
        
        return max;
    }
}
