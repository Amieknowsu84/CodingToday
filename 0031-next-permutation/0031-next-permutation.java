class Solution {
    public void nextPermutation(int[] nums) {
        
      //[3,2,4,5,1]
      //[1,3,2] 
      //  
      //step1. find the next smaller number from right.
      int ind = nums.length-1;
      while(ind>0){
          if(nums[ind-1]>=nums[ind])
              ind--;
          else
              break;
      }
        
      if(ind == 0){
          Arrays.sort(nums);
      }else{
          int si = nextGreaterElemFromLast(nums,nums[ind-1]);
          int temp = nums[ind-1];
          nums[ind-1] = nums[si];
          nums[si] = temp;
          //System.out.println(ind);
          reverse(nums,ind);
      } 
        
    }
    
    
    
    void reverse(int[] nums,int st){
        int i = st;
        int j = nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    
    
    
    int nextGreaterElemFromLast(int[] nums,int elem){
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] > elem){
                return i;
            }
        }
        return -1;
    }
}