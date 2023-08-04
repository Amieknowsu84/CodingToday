class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
         
         HashSet<String> set=new HashSet<>(wordDict);
         Boolean map[]=new Boolean[s.length()+1];
         return convert(s,set,new StringBuilder(),0,map);
        
    }

    boolean convert(String s,HashSet<String> set,StringBuilder sb,int index,
    Boolean map[]){
     if(index==s.length()){
        
         if(sb.toString().isEmpty()){
             return true;
         }else{
             return false;
         }
     }

     if(map[index]!=null){
         return map[index];
     }

     for(int i=index;i<s.length();i++){
         sb.append(s.charAt(i));
         if(set.contains(sb.toString()) &&
               convert(s,set,new StringBuilder(),i+1,map)){
           return map[index]=true;
         }
     }

    return map[index]=false;
      
    }
}