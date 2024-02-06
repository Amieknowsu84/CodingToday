class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        List<List<String>> result= new ArrayList<>();
        
       for(String str:strs){
           boolean added = false;   
           for(List<String> subList:result){
               if(hasEqualCharacters(str,subList.get(0))){
                   subList.add(str);
                   added = true;
                   break;
               }
           }
           
           if(!added){
              List<String> subList = new ArrayList<>();
              subList.add(str);
              result.add(subList); 
           }   
       }
        
       return result; 

    }
    
    boolean hasEqualCharacters(String a,String b){
        if(a.length() != b.length()){
            return false;
        }
        
        int map[] = new int[26];
        int len = a.length();
        
        for(int i=0;i<len;i++){
            map[a.charAt(i)-'a']++;
            map[b.charAt(i)-'a']--;
        }
        
        return Arrays.stream(map).allMatch(elem->elem==0);
    }
    
    
}