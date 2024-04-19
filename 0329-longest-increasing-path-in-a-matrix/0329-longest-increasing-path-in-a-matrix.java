class Solution {
    
    int m;
    int n;
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        Integer[][] dp = new Integer[m][n];
        
        int max = 0;
        
        // Traverse each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, dp, i, j));
            }
        }
        
        return max; 
    }
    
    // Depth First Search with memoization
    int dfs(int[][] matrix, Integer[][] dp, int i, int j) {
        // If the cell is out of boundaries, return 0
        if (!inBoundaries(i, j)) {
            return 0;
        }
        
        // If the value is already calculated, return it from dp array
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        
        int[] row = {0, 1, 0, -1};
        int[] col = {1, 0, -1, 0};
        int max = 0;
        
        // Check each neighbor
        for (int k = 0; k < row.length; k++) {
            int ni = i + row[k];
            int nj = j + col[k];
            
            // If the neighbor is within boundaries and has a greater value
            if (inBoundaries(ni, nj) && matrix[i][j] < matrix[ni][nj]) {
                max = Math.max(max, dfs(matrix, dp, ni, nj));
            }
        }
        
        // Update dp array and return the longest increasing path length
        return dp[i][j] = 1 + max;
    }
    
    // Helper function to check if a cell is within boundaries
    boolean inBoundaries(int i, int j) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}
