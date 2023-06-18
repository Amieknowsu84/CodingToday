class Solution {
    private static final int MOD = 1000000007;
    private int m;
    private int n;
    private int[][] dp;
    private int[][] matrix;
    private int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    
    public int countPaths(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = (sum + dfs(i, j)) % MOD;
            }
        }
        return sum;
    }
    
    private int dfs(int i, int j) {
        if (!inBoundaries(i, j)) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int sum = 1;
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (inBoundaries(ni, nj) && matrix[i][j] < matrix[ni][nj]) {
                sum = (sum + dfs(ni, nj)) % MOD;
            }
        }
        
        return dp[i][j] = sum % MOD;
    }
    
    private boolean inBoundaries(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
