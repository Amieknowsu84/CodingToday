class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for(int happy:happiness){
            heap.add(happy);
        }
        
        long maxSum = 0;
        int negative = 0;
        while(!heap.isEmpty() && k > 0){
            int current = heap.remove()-negative;
            if(current > 0){
                maxSum += current;
            }else{
                break;
            }
            negative++;
            k--;
        }
        
        return maxSum;
        
    }
}