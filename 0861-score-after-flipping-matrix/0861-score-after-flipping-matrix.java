class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int result = 0;
        
        result += (1 << (n-1))*m;
        
        for(int j = 1;j < n;j++){
            int same = 0;
            for(int i = 0;i < m;i++){
                if(A[i][0] == A[i][j])
                    same++;
            }
            result += (1 << (n-1-j))*Math.max(same,m-same);
        }
        
        return result;
        
    }
}