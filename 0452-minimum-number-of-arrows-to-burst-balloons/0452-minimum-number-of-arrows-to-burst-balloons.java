class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> Integer.compare(a[0],b[0]));
        int[] prev = points[0];
        int cnt = 1;
        for(int i=1; i< points.length;i++){
            //System.out.println(prev[1] +" "+ points[i][0]);
            if(prev[1] >= points[i][0]){
                prev[0] = Math.max(prev[0],points[i][0]);
                prev[1] = Math.min(prev[1],points[i][1]);
            }else{
                prev = points[i];
                cnt++;
            }
        }
        
        return cnt;
    }
}