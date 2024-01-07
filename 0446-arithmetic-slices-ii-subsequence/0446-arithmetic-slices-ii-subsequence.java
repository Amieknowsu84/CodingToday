class Solution {
    int cnt=0;
    
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[nums.length];
		
         for (int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
               long diff = (long)nums[i] - nums[j];
               if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) 
                   continue;
               int d =  (int)diff;
               int c1 = map[i].getOrDefault(d, 0);
               int c2 = map[j].getOrDefault(d, 0);
               res += c2;
               map[i].put(d, c1 + c2 + 1);
          }
       }
		
      return res;
    }
 
}