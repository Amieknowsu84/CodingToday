class Solution {
    Integer cache[];
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] interval = new int[startTime.length][3];
        
        for(int i = 0; i<startTime.length; i++){
            interval[i][0] = startTime[i];
            interval[i][1] = endTime[i];
            interval[i][2] = profit[i];
        }
        
        cache = new Integer[startTime.length];
        Arrays.sort(interval,(a,b)->a[0]-b[0]);
        return jobs(0,interval);
    }
    
    
    int jobs(int index,int[][] interval){
        if(index >= interval.length){
            return 0;
        }
        
        if(cache[index]!=null){
            return cache[index];
        }
        
        int netProfit = 0;
        
        //don't include 
        netProfit = jobs(index+1,interval);
        
        //if we incude
         int i = 0;
        //find the next intervals which has start time greater than equal to
        //current end time
        for(i = index+1 ; i < interval.length; i++){
              if(interval[i][0] >= interval[index][1]){
                  break;
              }
        }
        return cache[index]=Math.max(netProfit,interval[index][2]+jobs(i,interval));
        
    }
}