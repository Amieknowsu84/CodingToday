class Solution {
    //Given an integer array nums of unique elements,
    //The solution set must not contain duplicate subsets
    //Return the solution in any order.

 
    
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        int startIndex=0;
        generate(nums,startIndex,new LinkedList<Integer>());
        return result;
    }
    
    void generate(int[] nums,int startIndex,LinkedList<Integer> list){
        if(startIndex==nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        list.add(nums[startIndex]);
        generate(nums,startIndex+1,list);
        list.removeLast();
        generate(nums,startIndex+1,list);
        
    }
}