class Solution {
    
    // //[2,2,2,1,2,2,1,2,2,2], k = 2
    //            i         j
    // pc = 4
    // oc = 1
    // r = 1+1+1+1+4+4+4
    
    // [1,1,2,1,1]
            // i    j
    // k = 3
    // pc = 1
    // oc = 1+1+1
    // r = 2
        
    public int numberOfSubarrays(int[] A, int k) {
        int i = 0, j = 0, prevCount = 0, oddCount = 0, result = 0;
        
        while(j < A.length){
            if(A[j] % 2 != 0){
                oddCount++;
                prevCount = 0;
            }
                          
            while(oddCount == k){
                if(A[i] % 2 != 0){
                   oddCount--;
                }
                prevCount+=1;
                i++;
            }
            result+=prevCount;
            j++;
        }
        
        return result;
    
    }
}