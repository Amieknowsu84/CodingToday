class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1)
            return true;
        
        int left=1;
        int right=num/2;
        
        while(left <= right){
            int mid=left+ (right-left)/2;
            if(num%mid==0 && mid == num/mid){
                return true;
            }
            if(mid < num/mid){
                left= mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return false;
        
        
    
    }
}