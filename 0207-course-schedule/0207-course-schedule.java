class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites.length == 0){
            return true;
        }
        
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());    
        }
    
        
        for(int edge[]:prerequisites){
            adj.get(edge[0]).add(edge[1]);
        }
    
        //detect cycle in graph
        // since it is directed graph we need visited(2) array and 
        //path visited(1) to check if cycle lies in same path
        
        
        int visited[]=new int[numCourses];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                boolean result=dfs(adj,i,visited);
                if(!result)
                    return false;
            }
        }
        
        return true;
        
    }
    

    
    
    boolean dfs(List<List<Integer>> adj,int start,int visited[]){
        visited[start]=1;
        boolean result= true;
        //System.out.println(start+""+visited[start]);
        for(int adjNode:adj.get(start)){
            if(visited[adjNode]==0){
               result=dfs(adj,adjNode,visited);
            }else if(visited[adjNode]==1){
                result=false;
            }
            
            if(!result)
                return false;
        }
        visited[start]=2;
        //System.out.println(start+""+visited[start]);
        return result;
    }
}