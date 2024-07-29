class Solution {
     // Modified Dijkstra
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0] - 1).add(e[1] - 1);
            graph.get(e[1] - 1).add(e[0] - 1);
        }
        
        List<TreeSet<Integer>> minDists = new ArrayList<>();
        // Max pq.
        for (int i = 0; i < n; i++) minDists.add(new TreeSet<>());
        
        // Prep Dijkstra.
        PriorityQueue<int[]> pq = new PriorityQueue<>(10,
                                  (o1, o2) -> (o1[1] - o2[1]));
        pq.offer(new int[]{0, 0});
        
        // Main logic.
        PriorityQueue<Integer> res = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            
            // Dummy node.
            if (minDists.get(curNode).size() == 2 &&
                curDist > minDists.get(curNode).last()) {
                continue;
            }
            
            // Best First Expansion.
            for (int next : graph.get(curNode)) {
                // cur -> n;
                // if curDist / change % 2 == 1
                int nextDist = time + curDist;
                
                // Only record arrival time for dest.
                if (next == n - 1) {
                    res.add(nextDist);
                }
                
                // Traffic light correction.
                if ((nextDist / change) % 2 == 1) {
                    nextDist = ((nextDist / change) + 1) * change;
                }
                
                // Dup distance found.
                if (minDists.get(next).contains(nextDist)) {
                    continue;
                }
                
                // Push departure time to queue.
                if (minDists.get(next).size() < 2) {
                    minDists.get(next).add(nextDist);
                    pq.offer(new int[]{next, nextDist});
                } else if (minDists.get(next).last() > nextDist){
                    minDists.get(next).remove(minDists.get(next).last());
                    minDists.get(next).add(nextDist);
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }
        
        int top = res.peek();
        while (res.peek() == top) {
            res.poll();
        }
        
        return res.poll();
    }
}