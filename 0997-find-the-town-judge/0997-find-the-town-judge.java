class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if(n==1 && trust.length == 0){
            return 1;
        }
        
        int cnt = 0;
        int townJudge = -1;
        
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int tr[]:trust){
            set.add(tr[0]);
            map.put(tr[1],map.getOrDefault(tr[1],0)+1);
        }
        
        
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            
            if(entry.getValue() == n-1 && !set.contains(entry.getKey())){
                return entry.getKey();
            }
        }
        
        return -1;
    }
}