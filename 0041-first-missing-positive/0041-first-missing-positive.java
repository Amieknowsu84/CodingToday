class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean contain1=false;
        for(int i=0;i<nums.length;i++){
             if(nums[i]==1){contain1=true;}
            if(nums[i]<=0 || nums[i]>nums.length){nums[i]=1;}
        }

        if(contain1==false){return 1;}
        for(int i=0;i<nums.length;i++){
            int num=Math.abs(nums[i]);
            int idx=num-1;
            if(nums[idx]<0){continue;}
            nums[idx]*=-1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){return i+1;}
        }
        return nums.length+1;   
    }
}