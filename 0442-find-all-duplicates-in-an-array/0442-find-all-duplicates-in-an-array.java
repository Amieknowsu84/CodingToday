class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
           //get the index of the current element;
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0)
                result.add(index+1);
            else
                nums[index]=-nums[index];
        }
        
        return result;
        
    }
}