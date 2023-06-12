class Solution {
    public List<String> summaryRanges(int[] nums) {
    
        List<String> list=new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        
        int start=nums[0],end=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                end=nums[i];
            }else{
                addIntoList(start,end,list);
                start=nums[i];
                end=nums[i];                
            }
        }
        addIntoList(start,end,list);
        return list;
    }
    
    void addIntoList(int start,int end,List<String> list){
         if(start!=end){
            list.add(start+"->"+end);
        }else{
            list.add(start+"");
        }
    }
    
}