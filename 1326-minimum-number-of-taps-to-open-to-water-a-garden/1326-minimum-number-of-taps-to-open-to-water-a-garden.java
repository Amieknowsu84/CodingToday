class Solution {
    
    // 0,1,2,3,4... n taps
    // n
    // i-ranges[i], i+ranges[i]
    
    public int minTaps(int n, int[] ranges) {
        
        int startEnd[]=new int[n+1];
        
        for(int i=0;i<ranges.length;i++){
            int start=Math.max(0,i-ranges[i]);
            int end=Math.min(n,i+ranges[i]);
            startEnd[start]=Math.max(end,startEnd[start]);
        }
        
       int tap=0;
       int maxEnd=0;
       int curr=0;
        
        for(int i=0;i<=n;i++){
            if(i>maxEnd)
                return -1;
            if(i>curr){
                curr=maxEnd;
                tap++;
            }
            maxEnd=Math.max(maxEnd,startEnd[i]);
        }
        return tap;
    }
}