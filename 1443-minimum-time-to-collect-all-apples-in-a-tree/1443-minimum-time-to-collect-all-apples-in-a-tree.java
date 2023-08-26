class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        List<ArrayList<Integer>> adjacency = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacency.add(new ArrayList<>());
        }
        
        for(int edge[]:edges){
            adjacency.get(edge[0]).add(edge[1]);
             adjacency.get(edge[1]).add(edge[0]);
        }
            
        return findMinTime(0,adjacency,hasApple,-1);
        
    }
        
    
    
    int findMinTime(int index,List<ArrayList<Integer>> adjacency,List<Boolean> hasApple,
                    int parent)     {
       int time=0;
       for(Integer node:adjacency.get(index)){
           if(node!=parent)
            time+=findMinTime(node,adjacency,hasApple,index);
       }   
       if(index == 0){
           return time;
       } 
       if(time!=0||hasApple.get(index)){
           return 2+time;
       }
       return time; 
        
    }
    
    
}