class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if(n==1 && trust.length == 0){
            return 1;
        }
        
        int[] count = new int[n+1];
        
        for(int tr[]:trust){
            count[tr[0]] = -1;
            if(count[tr[1]]!=-1){
                count[tr[1]]++;
            }
        }
        
        for(int i=1;i<=n;i++){
            if(count[i]==n-1){
                return i;
            }
        }
        
        return -1;
    }
}