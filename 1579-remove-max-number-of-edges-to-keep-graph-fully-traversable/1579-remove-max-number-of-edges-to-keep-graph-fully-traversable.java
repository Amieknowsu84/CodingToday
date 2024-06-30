class DSU {
    private int[] parents;
    private int[] sizes;
    private int components;

    public DSU(int n) {
        components = n;
        parents = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
    }

    public int findParent(int u) {
        if (parents[u] != u) {
            parents[u] = findParent(parents[u]);
        }
        return parents[u];
    }

    public boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) {
            return false;
        }

        if (sizes[pu] > sizes[pv]) {
            sizes[pu] += sizes[pv];
            parents[pv] = pu;
        } else {
            sizes[pv] += sizes[pu];
            parents[pu] = pv;
        }

        components--;
        return true;
    }

    public int getComponents() {
        return components;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU aliceDSU = new DSU(n);
        DSU bobDSU = new DSU(n);

        int usedEdges = 0;

        // Process type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int u = edge[1] - 1;
                int v = edge[2] - 1;
                boolean aliceUnion = aliceDSU.union(u, v);
                boolean bobUnion = bobDSU.union(u, v);
                if (aliceUnion || bobUnion) {
                    usedEdges++;
                }
            }
        }

        // Process type 1 and 2 edges
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;

            if (type == 1) {
                if (aliceDSU.union(u, v)) {
                    usedEdges++;
                }
            } else if (type == 2) {
                if (bobDSU.union(u, v)) {
                    usedEdges++;
                }
            }
        }

        // Check if both Alice and Bob can traverse the graph
        if (aliceDSU.getComponents() == 1 && bobDSU.getComponents() == 1) {
            return edges.length - usedEdges;
        } else {
            return -1;
        }
    }
}