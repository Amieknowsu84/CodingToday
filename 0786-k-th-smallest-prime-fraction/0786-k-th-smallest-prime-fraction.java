
class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
       
       Comparator<int[]> comparator = (a,b)->{
          double val1 = (double)a[0]/a[1];
          double val2 = (double)b[0]/b[1];
          return -Double.compare(val1,val2); 
       };
        
       PriorityQueue<int[]> pq = new PriorityQueue<>(comparator); 
       
       for(int i = 0; i < A.length; i++){
           for(int j = i+1; j < A.length; j++){
               pq.add(new int[]{A[i], A[j]});
               if(pq.size()>K)
                   pq.remove();
           }
       } 
       return pq.remove();    
    }
}