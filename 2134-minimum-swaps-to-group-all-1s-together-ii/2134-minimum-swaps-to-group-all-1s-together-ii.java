class Solution {
    public int minSwaps(int[] nums) {
     
        int countOfOnes = countOnes(nums);
            //(int)Arrays.stream(nums).boxed().filter(a -> a == 1).count();
        int i = 0;
        int j = 0;
        int currentCount = 0;
        int ans = Integer.MAX_VALUE;
        //[0,1,0,1,1,0,0][0,1,0,1,1,0,0]
        
        while(j < 2*nums.length){
            if(nums[j % nums.length] == 1){
               currentCount++;    
            }
            
            if(j-i+1 >= countOfOnes){
                ans = Math.min(countOfOnes-currentCount,ans);
                
                if(nums[i % nums.length] == 1){
                    currentCount--;
                }
                i++;
            }
            j++;
        }
        
        
        return ans;
        
    }
    
    int countOnes(int[] nums){
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1)
                cnt++;
        }
        
        return cnt;
    }
}