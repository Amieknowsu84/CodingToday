class Solution {
    
//     ["A","A","A","B","B","B","B"]
//     [a,6] 0
//     [b,1] 0
//     [c,1] 0
//     [d,1]
//     [e,1]
//     [f,1]
//     [g,1] 
//     1 2 3 4 5 6 7 8 
//     a b   a b   a b
    
    public int leastInterval(char[] tasks, int n) {
        
        int count[]=new int[26];

        for(int i=0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
        }
        
        PriorityQueue<Character> pq=new PriorityQueue<>(
            (a,b)->count[b-'A']-count[a-'A'] );
        
        for(int i=0;i<count.length;i++){
            char c=(char)('A'+i);
            if(count[i]!=0)
             pq.add(c);
        }
        
        Queue<Pair<Character,Integer>> queue=new LinkedList<>();
        
        int time=0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            
            if(!queue.isEmpty() && queue.peek().getValue()<=time){
              pq.add(queue.remove().getKey());    
            }
           if(!pq.isEmpty()){ 
           char character=pq.remove();
           count[character-'A']--; 
            
           if(count[character-'A']==0){
               pq.remove(character);
           }else{ 
              Pair p=new Pair(character,time+n+1);
              queue.add(p);    
           }
           }    
            
        }
        
        return time;
    }
}