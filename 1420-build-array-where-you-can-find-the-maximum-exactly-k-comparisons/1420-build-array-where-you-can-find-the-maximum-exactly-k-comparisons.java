class Solution {
   public int numOfArrays(int n, int m, int k) {
        Integer[][][] dp = new Integer[n + 1][m + 1][k + 1];
        return dfs(n, m, k, 0, 0, 0, dp);
    }
    // dfs(... i, currMax, currCost) the number of ways to build the valid array `arr[i:]`
    //     keeping in mind that current maximum element is `currMax` and current search cost is `currCost`
    int dfs(int n, int m, int k, int i, int currMax, int currCost, Integer[][][] dp) {
        if (i == n) {
            if (k == currCost) return 1; // valid if the value search cost is equal to k
            return 0;
        }
        if (dp[i][currMax][currCost] != null) return dp[i][currMax][currCost];
        int ans = 0;
        // Case 1: num in range [1, currMax], newMax = currMax, newCost = currCost
        ans += (long) currMax * dfs(n, m, k, i + 1, currMax, currCost, dp) % 1_000_000_007;

        // Case 2: num in range [currMax+1, m], newMax = num, newCost = currCost + 1
        if (currCost + 1 <= k) {
            for (int num = currMax + 1; num <= m; num++) {
                ans += dfs(n, m, k, i + 1, num, currCost + 1, dp);
                ans %= 1_000_000_007;
            }
        }
        return dp[i][currMax][currCost] = ans;
    }

}