class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        
        
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(new int[]{ edge[1],edge[2] });
             adj.get(edge[1]).add(new int[]{ edge[0],edge[2] });
            
        }
        
        int[] time = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> time[a[0]]-time[b[0]]);
        pq.add(new int[]{0,0});
        time[0] = 0;
        
        while(!pq.isEmpty()){
        
            int[] nodeData = pq.remove();
            int node = nodeData[0];
            int t = nodeData[1];
            
            
            if (t > time[node]) continue;
            
            for(int[] adjacent: adj.get(node)){
                int timetaken = t + adjacent[1];
                if(timetaken < time[adjacent[0]] && timetaken < disappear[adjacent[0]]){
                    time[adjacent[0]] = timetaken;
                    pq.add(new int[]{adjacent[0],timetaken});
                }
            }
        }
        
        for(int i=0; i<time.length; i++){
            if(time[i] == Integer.MAX_VALUE){
                time[i] = -1;
            }
        }
        
        return time;
        
    }
}