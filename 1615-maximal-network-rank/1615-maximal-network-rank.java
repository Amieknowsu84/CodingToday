class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }
        
        for (int[] edge : roads) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }  
      
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            int iSize=adj.get(i).size();
            for (int j = i + 1; j < n; j++) {
                int sum = iSize + adj.get(j).size();
                if (adj.get(i).contains(j)) {
                    sum--;
                }
                max = Math.max(max, sum);
            }
        }   
        
        return max; 
    }
}
