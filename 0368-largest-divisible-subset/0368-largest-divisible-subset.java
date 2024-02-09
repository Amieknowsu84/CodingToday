class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
       // 2/1
       // [1,2,5,4,9,8]
       // [1,2,2]
       // [0,0,0]
        
        Arrays.sort(nums);
        int len[] = new int[nums.length];
        int indices[] = new int[nums.length];
        
        int maxIndex = 0;
        int maxLen = 0;
        
        List<Integer> result=new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int index = i;
            int length = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j] == 0 && len[j]>= length){
                    index = j;
                    length = len[j];
                }
            }
            indices[i] = index;
            len[i] = length + 1;
            
            if(len[i]>maxLen){
                maxLen = len[i];
                maxIndex = i;
            }
        }
        
        int i = maxIndex;
        while(indices[i] != i){
            result.add(nums[i]);
            i = indices[i];
        }
        
        result.add(nums[i]);
        
        return result;
    }
}