class Solution {
// //   0  1  2  3  4  5  6 7  8  9  10 11 12   
// [-31,-25,-72,79,-74,65  ,84,   91,-18,-59,-27,-9,81,-33,-17,-58]
// 11
// 2
 
      
      
// // 16 len
// //    k= 11 10 9  8 7 6 5 4 3 2 1
// //    cost=
// // candidates= 2
// //       rb= 23
// //       lb= 21
      // 
      
    
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> lpq=new PriorityQueue<>();
        PriorityQueue<Integer> rpq=new PriorityQueue<>();
        long cost=0;
        
        int rb=candidates;
        for(int i=0;i<candidates;i++){
            lpq.add(costs[i]);
        }
        
        int lb=costs.length-candidates-1;
        
        for(int i=(rb>lb)?rb:lb+1;i<costs.length;i++){
            rpq.add(costs[i]);
        }
        
            for(int i=0;i<k;i++){
                
                // System.out.println("left pq"+lpq);
                //System.out.println("right pq"+rpq);
                
               
                int leftElem=lpq.isEmpty()?Integer.MAX_VALUE:lpq.peek();
                int rightElem=rpq.isEmpty()?Integer.MAX_VALUE:rpq.peek();
                // System.out.println("left"+leftElem);
               // System.out.println("right"+rightElem);
                
                
                if(leftElem<=rightElem){
                    cost+=lpq.remove();
                    if(rb<=lb && rb<costs.length){
                        lpq.add(costs[rb]);
                        rb++;
                    }
                }else{
                    cost+=rpq.remove();
                    if(rb<=lb && lb>=0){
                        rpq.add(costs[lb]);
                        lb--;
                    }
                }
            }
            
        
        return cost;
        
    }
}