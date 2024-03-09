class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0;
        
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]){
                return nums1[index1];
            }else if(nums1[index1] > nums2[index2]){
                index2++;
            }else{
                index1++;
            }
        }
        
        return -1;
    }
}