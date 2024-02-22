class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCounts = new int[n + 1];
        
        for (int[] tr : trust) {
            int a = tr[0];
            int b = tr[1];
            trustCounts[a]--; // decrease trust count for person a
            trustCounts[b]++; // increase trust count for person b
        }
        
        for (int i = 1; i <= n; i++) {
            // If a person's net trust value is n - 1, they are the judge
            if (trustCounts[i] == n - 1) {
                return i;
            }
        }
        
        return -1; // judge not found
    }
}