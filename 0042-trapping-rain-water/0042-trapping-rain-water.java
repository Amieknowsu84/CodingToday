class Solution {
    public int trap(int[] height) {
        
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = height.length-1;
        int result = 0;
        
        while(l<=r){
            
            // I can ensure that there is a building of higher or equal height
            if(height[l] <= height[r]){
             
                //if the current building is lesser than leftMax mean we can store water equal to leftMax - height[r]
                if(height[l] < leftMax){
                     result += leftMax-height[l];                
                }else{
                    // we found a height greater than left max
                    leftMax = height[l];
                }
                l++;
                
            }else{
                // I can ensure that there is a building of higher or equal height in left
                if(height[r] < rightMax){
                    result += rightMax-height[r];
                }else{
                    rightMax = height[r];
                }
                r--;
            }
            
        }
        
        return result;
    }
}