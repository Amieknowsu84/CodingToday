class MyHashMap {
    
     private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int SIZE = 1023;
    private LinkedList<Entry> bucket[];

    public MyHashMap() {
        bucket=new LinkedList[SIZE];
    }
    
    public void put(int key, int value) {
        int hashKey = key % SIZE;
        if(bucket[hashKey] == null){
            bucket[hashKey] = new LinkedList<Entry>();
        }else{
            for(Entry currentEntry:bucket[hashKey]){
                if(currentEntry.key == key){
                    currentEntry.value = value;
                    return;
                }
            }
        }
        bucket[hashKey].add(new Entry(key,value));
        
    }
    
    public int get(int key) {
        
         int hashKey = key % SIZE;
         if(bucket[hashKey] == null){
            return -1;
         }
        
          for(Entry currentEntry:bucket[hashKey]){
                if(currentEntry.key == key){
                    return currentEntry.value;
                }
          }
        
        return -1; 
    }
    
    public void remove(int key) {
        
         int hashKey = key % SIZE;
         if(bucket[hashKey] == null){
            return;
         }
        
        int index=0;
          for(Entry currentEntry:bucket[hashKey]){
                if(currentEntry.key == key){
                    break;
                }
              index++;
          }
        if(index < bucket[hashKey].size()){
            bucket[hashKey].remove(index);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */