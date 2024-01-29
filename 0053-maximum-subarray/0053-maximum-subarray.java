class Solution {
    
    public int maxSubArray(int[] nums) {
      
        int sumSoFar=nums[0],maxSum=nums[0];
        
        for(int i=1;i<nums.length;i++){
            
            sumSoFar=sumSoFar+nums[i];//from back+nums[i]
            
        //every no thinks if from back i am getting better that is +ve then                   continue by adding it else take only me nums[i] and start fresh 
            
           if(sumSoFar<nums[i])//take only me
               sumSoFar=nums[i];
            
            if(sumSoFar>maxSum)//keep track of max
                maxSum=sumSoFar;
            
        }
        
        return maxSum;
        
        
    }
}