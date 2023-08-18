class Solution {
    int target;
    int k;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=Arrays.stream(nums).sum();
        if(sum%k!=0){
            return false;
        }else{
            target=sum/k;
            this.k=k;
            //System.out.println(target);
            Arrays.sort(nums);
            return findSubSetSum(nums,target,0);
        }
    }
    
     boolean findSubSetSum(int nums[],int sum,int index){

          if(sum==0){
                  boolean result=false;
                  k--;      
                  if(k==0){
                    return true;
                  }else{
                    result = findSubSetSum(nums,target,0);
                  }
                  k++;
                  return result;
          }     
       
        
    
         if(index >= nums.length){
           return false;    
         }  
         
         for(int i=index;i<nums.length;i++){
             if(nums[i]!=-1 && sum>=nums[i]){
                 int curr=nums[i];
                 nums[i]=-1;
                 if(findSubSetSum(nums,sum-curr,i+1))
                     return true;
                 nums[i]=curr;
             }
         }
         
        return false;
     }
}