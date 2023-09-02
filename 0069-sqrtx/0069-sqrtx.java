class Solution{
        
    public int mySqrt(int x) {
        if(x==0 || x==1)
            return x;
        
        int ans=0;
        int left=1;
        int right=x/2;
        
        while(left <= right){
            int mid=left+ (right-left)/2;
            if(mid == x/mid){
                return mid;
            }
            //System.out.println(left+" "+right+" "+mid);
            if(mid < x/mid){
                ans=mid;
                left= mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return ans;
        
        
    }
}