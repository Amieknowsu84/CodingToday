class Solution {
    public int lengthOfLIS(int[] nums) {
       
        ArrayList<Integer> lis = new ArrayList<>();
        
        for(int num:nums){
            
            int size = lis.size();
            
            if(size==0 || num>lis.get(size-1)){
                lis.add(num);
            }else{
                //find the position that is <= target elemenet
                int insertIndex = bs(lis,num);
                //insert at that pos
                lis.set(insertIndex,num);
            }
        }
        
        return lis.size();
    }
    
        
    int bs(List<Integer> list, int target){
        int lo = 0;
        int hi = list.size()-1;
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(list.get(mid)<target){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return lo;
    }
}