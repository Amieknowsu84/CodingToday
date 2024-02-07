class Solution {
    public String frequencySort(String s) {
       Map<Character,Integer> map = new HashMap<>();
        
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
             char current = pq.poll();
             int n = map.get(current);
             for(int i=0;i<n;i++)
               result.append(current);
        }
        
        return result.toString();
        
    }
}