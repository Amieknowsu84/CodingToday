class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        long sum = 0;
        int remainder = 0;
        map.put((int)(sum % k) , 1);
        int cnt = 0;
        
        for(int num: nums){
            sum+=num;
            remainder = (int)(sum % k);
            remainder = (remainder < 0) ? (remainder + k): remainder;
            int val = map.getOrDefault(remainder, 0);
            cnt+=val;
            map.put(remainder,val+1);
        }
        
        return cnt;
    }
}