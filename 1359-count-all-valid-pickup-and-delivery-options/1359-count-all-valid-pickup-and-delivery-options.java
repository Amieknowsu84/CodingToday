class Solution {
    public int countOrders(int n) {
        int result = 1;
        
        if(n==1)
            return result;
        
        long mod = 1000000007;
        
        for(int i=2;i<=n;i++){
            int spaces = (i-1)*2+1;
            int possiblities = (spaces*(spaces+1))/2;
            result = (int)((possiblities%mod)*(result%mod)%mod);
        }
        
        return result;
    }
}