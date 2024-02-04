class Solution {
    /*
    s = "ADOBECODEBANC", t = "ABC"
    */
    public String minWindow(String s, String t) {  
        
        if(t.length()<=s.length() &&s.substring(0,t.length()).equals(t)){
            return t;
        }
        
        Map<Character,Integer> tmap = new HashMap<>();
        
        for(Character c:t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        
        int si = 0;
        int ei = 0;
        int min = s.length()+1;
        String res = "";
        
        while(ei <= s.length()){
            boolean allCharFound = tmap.entrySet().stream().allMatch(e->e.getValue()<=0);
            //System.out.println(si+" "+ei+" "+tmap+" "+allCharFound);
            
            if(allCharFound){
                int currentLength = ei-si+1;
                if(min >= currentLength){
                   min  =  currentLength;
                   res = s.substring(si,ei);
                }
                char currStart = s.charAt(si++);
                if(tmap.containsKey(currStart)){
                    tmap.put(currStart,tmap.get(currStart)+1);
                }
            }else{
                if(ei<s.length()){
                 char currEnd = s.charAt(ei);
                 if(tmap.containsKey(currEnd)){
                    tmap.put(currEnd,tmap.get(currEnd)-1);
                 }
                }
                ei++;
            }
        }
        
                   
       return res;            
    }
}