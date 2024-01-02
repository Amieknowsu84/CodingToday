class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        int map[] = new int[201];
        
        for(int num:nums){
            map[num]++;
        }
        
        while(true){
            
            List<Integer> temp = new ArrayList<>();
            
            for(int i=0; i<map.length; i++){
                if(map[i] > 0){
                   temp.add(i);
                   map[i]--;
                }
            }
            
            if(temp.size() == 0){
                break;
            }else{
                //System.out.println(temp);
                result.add(temp); 
            }
        }
        
        return result;
    }
}