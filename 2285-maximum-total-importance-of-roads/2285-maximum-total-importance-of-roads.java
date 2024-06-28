class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] connections = new int[n];
        
        for(int[] edge: roads){
            connections[edge[0]]++;
            connections[edge[1]]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue((a,b)->connections[(int)b]-connections[(int)a]);
        for(int i=0;i<n;i++){
          pq.add(i);   
        }
        
        long val = n;
        long sum = 0;
        while(!pq.isEmpty()){
            int node = pq.remove();
            //System.out.println(connections[node]);
            sum+= connections[node]*val;
            val--;
        } 
        
        return sum;
    }
}