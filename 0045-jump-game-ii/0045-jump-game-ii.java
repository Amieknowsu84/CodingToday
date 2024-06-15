class Solution {
    public int jump(int[] nums) {
        
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        //[2,3,1,1,4]
        //[0,1,1,2,2]
        
        for(int i=0; i <nums.length; i++){
            int maxJump = i+nums[i]; //1+3=4
            int val = jumps[i]; // 1
            for(int j = i+1; j<=maxJump && j<nums.length; j++){
                jumps[j] = Math.min(jumps[j], val+1);
            }
        }
        
        
        return jumps[nums.length-1];
        
    }
}