class Solution {
    
//      0 1 2 3 4
//     [5,3]
         
//          sum=8/4
         
    int cnt;
    int side;
    HashSet<Integer> indices;
    
    public boolean makesquare(int[] matchsticks) {
        cnt=0;
        int sum=Arrays.stream(matchsticks).sum();
        if(sum%4!=0||matchsticks.length<4){
            return false;
        }
        side=sum/4;
        indices=new HashSet<>();
        return solve(matchsticks,side,new LinkedList<Integer>(),0);
        
    }
    
    
    boolean solve(int[] matchsticks,int target,LinkedList<Integer> list,int index){
        
        if(target==0){
            cnt++;
            //System.out.println(list+" "+cnt);
            indices.addAll(list);
            boolean result=false;
            if(cnt==4){
               return true; 
            }else{
                result = solve(matchsticks,side,new LinkedList<Integer>(),0);
            }
            indices.removeAll(list);
            cnt--;
            return result;
        }
        
        for(int i=index;i<matchsticks.length;i++){
            if(!indices.contains(i) && target>=matchsticks[i]){
                list.add(i);
                if(solve(matchsticks,target-matchsticks[i],list,i+1)){
                    return true;
                }
                list.removeLast();
            }
        }
        
        return false;
        
    }
}