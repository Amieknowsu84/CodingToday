class DSU{
    List<Integer> parents;
    List<Integer> sizes;
    int components;
    
    public DSU(int n){
        components = n;
        parents = new ArrayList<>();
        sizes = new ArrayList<>();
        for(int i=0;i<n;i++){
            parents.add(i);
            sizes.add(1);
        }
    }
    
    public int findParent(int u) {
        if(parents.get(u) == u){
            return u;
        }
        int parent = findParent(parents.get(u));
        parents.set(u,parent);
        return parent;
    }
    
    public void union(int u,int v){
       int pu = findParent(u);
       int pv = findParent(v);
       
       if(pu == pv){
           return;
       } 
        
       if(sizes.get(pu) > sizes.get(pv)){
           sizes.set(pu,(sizes.get(pu) + sizes.get(pv)));
           parents.set(pv,pu);          
       }else{
           sizes.set(pv,(sizes.get(pv) + sizes.get(pu)));
           parents.set(pu,pv);  
       }
       
       components--;
        
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
       DSU aliceDSU = new DSU(n);
       DSU bobDSU = new DSU(n);
        
       Arrays.sort(edges,(a,b)->b[0]-a[0]);
       
       int usedEdges = 0; 
       int type = -1;
       int u = -1;
       int v = -1;
       boolean edgeUsed = false;
        
       for(int[] edge: edges){
           type = edge[0];
           u = edge[1]-1;
           v = edge[2]-1;
           edgeUsed = false;
           
           if(type == 3){
               if(aliceDSU.findParent(u) != aliceDSU.findParent(v)){
                   aliceDSU.union(u,v);
                   edgeUsed = true;
               }
               
               if(bobDSU.findParent(u) != bobDSU.findParent(v)){
                   bobDSU.union(u,v);
                   edgeUsed = true;
               }   
           }else if(type == 2){
                if(bobDSU.findParent(u) != bobDSU.findParent(v)){
                   bobDSU.union(u,v);
                   edgeUsed = true;
               }  
               
           }else{
               if(aliceDSU.findParent(u) != aliceDSU.findParent(v)){
                   aliceDSU.union(u,v);
                   edgeUsed = true;
               } 
           }
           
           if(edgeUsed){
              usedEdges++; 
           }
       }
        
       if(aliceDSU.components == 1 && bobDSU.components == 1){
           return edges.length-usedEdges;
       }else{
           return -1;
       }
        
        
    }
}