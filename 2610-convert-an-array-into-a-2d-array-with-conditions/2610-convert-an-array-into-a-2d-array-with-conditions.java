class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        int map[] = new int[201];
        
        int maxCnt = 0;
        
        for(int num:nums){
            map[num]++;
            if(result.size()<map[num]){
                result.add(new ArrayList<>());
            }
            result.get(map[num]-1).add(num);
        }
        
        return result;
    }
}