class Solution {
     public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return isValidString(s, dp, 0, 0);
    }

    private boolean isValidString(String s, int[][] dp, int currIndex, int count) {
        // at any point of time if closing bracket is more that opening bracket 
        // it can not be balanced further so for sure c
        if (count < 0) {
            return false;
        }
        if (currIndex == s.length()) {
            return count == 0;
        }
        if (dp[currIndex][count] != -1) {
            return dp[currIndex][count] == 1;
        }

        boolean isValid = false;
        char c = s.charAt(currIndex);
        if (c == '*') {
             // Check for all three possibilities for '*'
            isValid = isValidString(s, dp, currIndex + 1, count + 1) ||
                      isValidString(s, dp, currIndex + 1, count) ||
                      isValidString(s, dp, currIndex + 1, count - 1); 
        }else if (c == '(') {
            // Increase balance for '('
            isValid = isValidString(s, dp, currIndex + 1, count + 1);
        }else if (c == ')') {
            // Decrease balance for ')'
            isValid = isValidString(s, dp, currIndex + 1, count - 1);
        }

        dp[currIndex][count] = isValid ? 1 : 0;
        return isValid;
    }
    
}