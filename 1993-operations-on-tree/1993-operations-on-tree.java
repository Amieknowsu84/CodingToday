class LockingTree {
    int[] parent;
    Map<Integer,Integer> lock;
    List<ArrayList<Integer>> adjacency;
    
    public LockingTree(int[] parent) {
        this.parent = parent;
        this.lock = new HashMap<>();
        this.adjacency = new ArrayList<>();
        
        for(int i=0;i<parent.length;i++){
            adjacency.add(new ArrayList<>());
        }
        
         for(int i=0;i<parent.length;i++){
             if(parent[i]!=-1)
              adjacency.get(parent[i]).add(i);
         }   

    }
    
    public boolean lock(int num, int user) {
        if(lock.containsKey(num)){
            return false;
        }
        lock.put(num,user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!lock.containsKey(num)){
            return false;
        }
        
        int lockUser = lock.get(num);
        
        if(user == lockUser){
            lock.remove(num);
            return true;
        }
        
        return false;
    }
    
    public boolean upgrade(int num, int user) {
       if(!areNodeAndParentUnlocked(num)){
           return false;
       } 
       
       if(atleastOneDescendantLock(num)){
           lock.put(num,user);
           return true;
       } 
       return false; 
    }
    
    boolean atleastOneDescendantLock(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        boolean result = false;
        
        while(!queue.isEmpty()){
            int node = queue.remove();
            for(int child:adjacency.get(node)){
               if(lock.containsKey(child)){
                   result = true;
                   lock.remove(child);
                }
                queue.add(child);
            }
        }
        
        return result;   
    }
    
    boolean areNodeAndParentUnlocked(int num){
        
        if(lock.containsKey(num)){
            return false;
        }
        
        num=parent[num];
        
        while(num!=-1){
            if(lock.containsKey(num)){
                return false;
            }
            num=parent[num];
        }
        
        return true;
        
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */