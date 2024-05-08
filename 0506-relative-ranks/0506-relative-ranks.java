class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->score[b]-score[a]);
        
        for(int i=0; i<score.length; i++){
            pq.add(i);
        }
        
        String[] result = new String[score.length];
        int cnt = 1;
        
        while(!pq.isEmpty()){
            int num = pq.remove();
            if(cnt == 1){
                result[num] = "Gold Medal";
            }else if(cnt == 2){
                 result[num] = "Silver Medal";
            }else if(cnt == 3){
                 result[num] = "Bronze Medal";
            }else{
                 result[num] = ""+cnt;
            }
            cnt++;
        }
        
        return result;
    }
}