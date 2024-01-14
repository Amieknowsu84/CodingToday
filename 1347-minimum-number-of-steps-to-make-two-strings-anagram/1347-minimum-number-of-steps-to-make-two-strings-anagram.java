class Solution {
    public int minSteps(String s, String t) {
        //int map[]= new int[26];
        Map<Character,Integer> map = new HashMap<>();
        for(char character: s.toCharArray()){
            map.put(character,map.getOrDefault(character,0)+1);
        }
        
        //int count = 0;
        
        for(char character: t.toCharArray()){
            if(map.containsKey(character)){
                if(map.get(character)>0){
                    map.put(character,map.get(character)-1);
                }else{
                    map.put(character,0);
                }
            }
        }
        
        //map.entrySet().forEach(entry->System.out.println(entry.getKey()+""+entry.getValue()));
        return map.entrySet().stream().map((entry)->entry.getValue()).reduce(0,(a,b)->a+b);
        
        
    }
}