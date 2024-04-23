class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // If there is only one node, return it as the root
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // Create an adjacency list to represent the graph
        List<Set<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new HashSet<>());
        }

        // Populate the adjacency list based on the given edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // Find the initial leaves of the tree
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjacencyList.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Trim the tree until only the roots remain
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                // Find the neighbor of the leaf node
                int neighbor = adjacencyList.get(leaf).iterator().next();
                // Remove the leaf from the neighbor's adjacency list
                adjacencyList.get(neighbor).remove(leaf);
                // If the neighbor becomes a leaf, add it to the new leaves list
                if (adjacencyList.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            // Update the leaves list for the next iteration
            leaves = newLeaves;
        }

        // The remaining nodes in the leaves list are the roots of the minimum height trees
        return leaves;
    }
}
