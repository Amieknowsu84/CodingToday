class Solution {
    
    // the core crux of the problem is if we choose such a node
    // that's in middle of the tree, we get the height as minimum.
    // steps
    // pull out leaves
    // remove leaves pull out next leaves 
    // keep on doing so till we have left 1 or 2 node 
    // that's the answer
    
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            int node = n-1;
            return Arrays.asList(node);
        }
        
        List<Set<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adjacencyList.add(new HashSet<>());
        }
        
        for(int[] edge:edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(adjacencyList.get(i).size() == 1){
                leaves.add(i);
            }
        }
        
       while(n > 2){
           n-= leaves.size();
           
           List<Integer> newLeaves = new ArrayList<>();
           
           for(int leaf:leaves){
               // adjacencyList.get(leaf) will have only 1 element
               // to get element from set we need iterator
               int neighbour = adjacencyList.get(leaf).iterator().next();
               adjacencyList.get(neighbour).remove(leaf);
               adjacencyList.get(leaf).remove(neighbour);
               if(adjacencyList.get(neighbour).size() == 1){
                   newLeaves.add(neighbour);
               }
           }
           
           leaves = newLeaves;
       }
        
       return leaves; 
    
    }
}