class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new TreeMap<>(Collections.reverseOrder());
        
        for(int i = 0; i < names.length; i++){
            map.put(heights[i],names[i]);
        }
        int index = 0;
        
        for(String name:map.values()){
            names[index++]=name;
        }
        
        return names;
        
    }
}