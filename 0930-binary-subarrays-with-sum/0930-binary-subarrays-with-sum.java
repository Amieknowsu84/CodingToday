class Solution {
    // [0,0,0,0,0]
    // 1-5 2-4, 3-3 4-2 5-1
    // 5*6/2 = 15
    
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum,1);
        
        int cnt = 0;
        
        for(int num:nums){
            sum += num;
            int val = map.getOrDefault(sum-goal,0);
            //System.out.println(sum+" "+map+" "+(sum-goal));
            cnt += val;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return cnt;
    }
}