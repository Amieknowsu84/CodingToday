class Solution {
    int maxTime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
      
       List<ArrayList<Integer>> adjacency = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacency.add(new ArrayList<>());
        }
        
        
        for(int i=0;i<n;i++){
            if(i!=headID)
              adjacency.get(manager[i]).add(i);
        }
      
        maxTime=0;
        countMinute(adjacency,headID,informTime,0);
        return maxTime;
    }
    
    
    
    void countMinute(List<ArrayList<Integer>> adjacency,int id,int informTime[],int time){
        if(time > maxTime){
            maxTime=time;
        }
        if(informTime[id]==0){
            return;
        }
        
        time+=informTime[id];
        
        for(Integer subOrdinate:adjacency.get(id)){
            countMinute(adjacency,subOrdinate,informTime,time);
        }
        
    
    }
}
 