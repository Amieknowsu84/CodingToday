class DisjointSet{
    private List<Integer> parents;
    private List<Integer> size;
    
    DisjointSet(int n){
        parents = new ArrayList<Integer>();
        size = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            parents.add(i);
            size.add(1);
        }
      
    }
    
    int findUltimateParent(int u){
        int parent = parents.get(u);
        if(u == parent){
            return u;
        }
        
        parent = findUltimateParent(parents.get(u));
        parents.set(u,parent);
        return parent;
    }
    
    void unionBySize(int u,int v){
        int uParent = findUltimateParent(u);
        int vParent = findUltimateParent(v);
        
        if(vParent == uParent)
            return;
        if(size.get(uParent) > size.get(vParent)){
            parents.set(vParent,uParent);
            size.set(uParent,size.get(uParent) + size.get(vParent));
        }else{
             parents.set(uParent,vParent);
             size.set(vParent,size.get(uParent) + size.get(vParent));
        }
        
    }
    
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination)     {
         DisjointSet dset = new DisjointSet(n);
        
         for(int[] edge: edges){
             dset.unionBySize(edge[0],edge[1]);
         }
        
         return dset.findUltimateParent(source) 
             == dset.findUltimateParent(destination);
    }

}

