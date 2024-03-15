class Solution {
    
    // [1,2,3,4  ]
    //  1 2 6 24
    //    12 8 6   24

    public int[] productExceptSelf(int[] nums) {
       int result[]=new int[nums.length];
       int postfixProduct = 1;
       int prevProduct = 1; 
       result[0] = nums[0];
                
      
        for(int i=1;i<nums.length;i++){
           result[i] = nums[i] * result[i-1];
        }
        
        for(int i=nums.length-1; i>0; i--){
           result[i] = result[i-1]*postfixProduct;
           postfixProduct = postfixProduct*nums[i]; 
        }
        result[0]=postfixProduct;
        
        return result;
    }
    
}