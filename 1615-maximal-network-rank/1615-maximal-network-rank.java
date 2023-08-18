class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
      List<HashSet<Integer>> adj=new ArrayList<>();
      for(int i=0;i<n;i++){
          adj.add(new HashSet<Integer>());
      }
        
      for(int edge[]:roads){
          adj.get(edge[0]).add(edge[1]);
          adj.get(edge[1]).add(edge[0]);
      }  
      
        int max=0;
        
     for(int i=0;i<n;i++){
         for(int j=i+1;j<n;j++){
            int rankI=adj.get(i).size();
            int rankJ=adj.get(j).size();
            int sum=rankI+rankJ;
            if(adj.get(i).contains(j)){
                 sum-=1;
             }
             
             max=Math.max(max,sum);
             
         }
     }   
        
        
       return max; 
        
        
        
    }
}