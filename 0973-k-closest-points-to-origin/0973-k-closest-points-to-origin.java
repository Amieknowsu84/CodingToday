class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //max priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int dist1 = a[0]*a[0]+a[1]*a[1];
            int dist2 = b[0]*b[0]+b[1]*b[1];
            return dist2-dist1;
        });
        
        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        
       int[][] result = new int[pq.size()][2];
       for(int i=0; i < result.length; i++){
           result[i] = pq.remove();
       }
        
       return result; 
    }
}