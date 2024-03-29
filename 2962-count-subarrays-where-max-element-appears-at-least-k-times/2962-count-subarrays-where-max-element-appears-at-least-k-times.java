class Solution {
    
    // [1,3,2,3,3], k = 2
    //   [1,3,2,3,3]  l = 0, r = 0, max = 3, maxcnt = 0, cnt  = 0
    //  1 3   l = 0, r = 1, max = 3, maxcnt = 1, cnt  = 0
    //  1 3 2   l = 0, r = 2, max = 3, maxcnt = 1, cnt  = 0
    //  1 3 2 3   l = 0, r = 3, max = 3, maxcnt = 2, cnt  = 2
        //  3 2 3   l = 1, r = 3, max = 3, maxcnt = 2, cnt  = 2
        //  2 3   l = 2, r = 3, max = 3, maxcnt = 1, cnt  = 4
    //  2 3 3  l = 2, r = 4, max = 3, maxcnt = 2, cnt  = 5
       //  3 3  l = 3, r = 4, max = 3, maxcnt = 2 , cnt  = 6
    //  3  l = 4, r = 5, max = 3, maxcnt = 2 , cnt  = 6
    
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).boxed().max(Integer::compare).get();
        int maxElementCnt = 0;
        long cnt = 0;
        int left = 0;
        int right = 0;
        
        while(right < nums.length){
            if(nums[right] == max){
                maxElementCnt++;
            }   
            while(maxElementCnt == k){
              cnt += nums.length - right; 
              if(nums[left] == max){
                   maxElementCnt--;
              }
              left++;  
            }
            right++;
        }
        
        return cnt;
    }
}