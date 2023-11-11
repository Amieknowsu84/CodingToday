class Graph {
    List<List<Pair<Integer,Integer>>> adjacencyList;
    
    public Graph(int n, int[][] edges) {
        adjacencyList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            addEdge(edges[i]);
        }
    }
    
    public void addEdge(int[] edge) {
        Pair pair = new Pair(edge[1],edge[2]);
        adjacencyList.get(edge[0]).add(pair);
    }
    
    public void print(){
        for(int i=0;i<adjacencyList.size();i++){
            System.out.print(i+"  [");
            for(Pair<Integer,Integer> pair1:adjacencyList.get(i)){
                System.out.print(pair1+" ");
            }
            System.out.println(" ]");
        }
    }
    
    public int shortestPath(int node1, int node2) {
          // Priority queue to store vertices and their distances
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.getValue()));
        
        // Distance array to store the shortest distance from node1 to each node
        int[] dist = new int[adjacencyList.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Add source node to the priority queue with distance 0
        pq.add(new Pair<>(node1, 0));
        dist[node1] = 0;
        
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            int u = current.getKey();
            int uDist = current.getValue();
            
            // If the current distance is greater than the stored distance, skip
            if (uDist > dist[u]) {
                continue;
            }
            
            // Iterate through neighbors of the current node
            for (Pair<Integer, Integer> neighbor : adjacencyList.get(u)) {
                int v = neighbor.getKey();
                int weight = neighbor.getValue();
                
                // Relaxation step: If a shorter path is found, update the distance
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair<>(v, dist[v]));
                }
            }
        }
        
        // Return the distance from node1 to node2
        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }

}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */