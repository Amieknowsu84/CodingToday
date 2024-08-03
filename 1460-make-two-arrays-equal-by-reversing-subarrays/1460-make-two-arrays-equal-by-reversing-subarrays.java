class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length)
            return false;
        
        int[] narr = new int[1001];
        
        for(int i=0;i<target.length;i++){
            narr[target[i]]++;
            narr[arr[i]]--;
        }
        
          for(int i=0;i<1001;i++){
              if(narr[i] != 0)
                  return false;
          }
        
        return true;
        
        
    }
}