class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        int map[] = new int[201];
        
        int maxCnt = 0;
        
        for(int num:nums){
            map[num]++;
            if(map[num]>maxCnt){
                maxCnt = map[num];
            }
        }
        
        for(int i=0;i<maxCnt;i++){
            result.add(new ArrayList<>());
        }
        
        for(int i=0; i<map.length; i++){
            while(map[i] > 0){
                   result.get(map[i]-1).add(i);
                   map[i]--;
            }
        }
    
        return result;
    }
}