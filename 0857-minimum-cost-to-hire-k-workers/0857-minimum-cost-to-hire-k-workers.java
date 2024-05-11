class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
         Integer[] index=new Integer[wage.length];
        for(int i=0;i<index.length;i++) index[i]=i;
        Arrays.sort(index,(a,b)->{
            long l=(long)wage[a]*quality[b],r=(long)wage[b]*quality[a];
            if(l==r) return 0;
            return l<r?-1:1;
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->quality[b]-quality[a]);
        double min=Double.MAX_VALUE;
        int sum=0;
        for(int i=0;i<index.length;i++) {
            int next=index[i];
            pq.add(next);
            sum+=quality[next];
            if(pq.size()>k) sum-=quality[pq.remove()];
            if(pq.size()==k) min=Math.min(min,(double)sum*wage[next]/quality[next]);
        }
        return min;
        
    }
}