class Solution {
    
    //[4,12,2,7,3,18,20,3,19]
    //10
    //2
    //7
    // cnt = 4
    // 5
    // 2 2,5 1,    
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        int ind = 0;
        
        while(ind < heights.length-1){
            if(heights[ind+1]<=heights[ind]){
                ind++;
                cnt++;
            }else{
                int required = heights[ind+1]-heights[ind];
                if(bricks >= required){
                    pq.add(required);
                    bricks-=required;
                }else if(ladders > 0){
                    if(!pq.isEmpty() && pq.peek() >= required){
                      bricks+=(pq.remove()-required);
                      pq.add(required);
                    }
                    ladders--;
                }else{
                    return cnt;
                }
                ind++;
                cnt++;
            }
        }
        
        return cnt;
        
    }
}