class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int max = 0,maxCnt = 0;
        for(int num:nums){
            count[num]++;
            if(count[num] == max){
                maxCnt++;
            }else if(count[num] > max){
                max = count[num];
                maxCnt = 1;
            }
        }
        return maxCnt*max;
    }
}