class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        // Using this set as visited and deadends both
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        
        int level=0;
        queue.add("0000");
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                
                String current = queue.remove();
                //System.out.println(current+" -- ");
                
                if(current.equals(target))
                    return level;
                
                if(set.contains(current)){
                   continue;
                }
                
                set.add(current);
                
                for(int j=0;j<4;j++){
                    char ith = current.charAt(j);
                    char next = ith == '9'? '0' :(char)(ith+1);
                    char prev = ith == '0'?'9' :(char)(ith-1);
                    String new1 = current.substring(0,j)+next+current.substring(j+1);
                    String new2 = current.substring(0,j)+prev+current.substring(j+1);
                    //System.out.println(new1+" --- "+new2);
                    queue.add(new1);
                    queue.add(new2);
                }
                
            }
            level++; 
        }
        
        return -1;
    }
}