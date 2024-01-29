class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result=new ArrayList<>();
        Arrays.sort(candidates);
        LinkedList<Integer> list = new LinkedList<>();
        
        prepareList(target,candidates,list,0);
        return result;
    }
    
    void prepareList(int target,int[] candidates,LinkedList<Integer> list,int index){
       
        if(target < 0){
            return ;
        }else if(target == 0){
            result.add(new ArrayList<>(list));
            return ;
        }
        
        for(int i=index;i<candidates.length;i++){
            if(i!=index && candidates[i] == candidates[i-1] ){
                continue;
            }
            list.add(candidates[i]);
            if(target-candidates[i]>=0)
              prepareList(target-candidates[i],candidates,list,i+1);
            list.removeLast(); 
        }   
    }
    
}