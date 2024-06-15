class Solution {
    
    // [2,3,1,1,4]
    // l = 3, r = 5, f = 5
    
    public int jump(int[] nums) {
       // idea is to use bfs in 1d array  
        
      //keep maintaining a window from where we can jump and upto where (l,r)
      //initially both left and right are at zero
      int l = 0, r = 0;
      // and the level we are at 0 means we are at start and don't need a jump
      int level = 0;
        
      // till when we will continue jump, till we are not in the end  [condition]
      // once we are in end i.e r in nums.length-1 no need to jump so keep jumping till < end-1  
       while(r < nums.length-1){
           // farthest will get us how much farther we can jump defining our r for next level
           int farthest = 0;
           for(int i = l; i<=r; i++){
               farthest = Math.max(farthest, i + nums[i]);
           }
           
           //what will be the left boundary i.e min start of next level
           // it will be prev level end +1;
           l = r + 1;
           r = farthest;
           
           //proceed to next level 
           level++;
       }
        
       return level; 
        
    }
}