class Solution {
    public int climbStairs(int n) {
        // 1 - 1
        // 2 - (1+1),2 2
        // 3 - (1+1+1),(1+2),(2+1) 3
        // 4 - (1+1+1+1),(1+2+1)(2+1+1)(1+1+2) (2+2)    
        // 5 - ()
        
        int num1=0,num2=1,sum=1;
        for(int i=0;i<n;i++){
            sum = num1+num2;
            num1 = num2;
            num2 = sum;
        }
        
        return num2;
    }
}