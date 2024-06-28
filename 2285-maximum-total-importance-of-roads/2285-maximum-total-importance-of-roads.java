class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] connections = new int[n];
        
        // Count the connections for each city
        for (int[] edge : roads) {
            connections[edge[0]]++;
            connections[edge[1]]++;
        }
        
        // Sort the cities based on the number of connections in descending order
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> connections[b] - connections[a]);
        
        // Calculate the maximum importance
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) connections[indices[i]] * (n - i);
        }
        
        return sum;
    }
}