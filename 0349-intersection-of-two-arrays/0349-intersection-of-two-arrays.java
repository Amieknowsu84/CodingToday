class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int left = 0;
        int right = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(left < nums1.length && right < nums2.length){
            if(nums1[left] == nums2[right]){
                int size = list.size();
                if(size == 0 || list.get(size-1) !=nums1[left])
                  list.add(nums1[left]);
                left++;
                right++;
            }else if(nums1[left]<nums2[right]){
                left++;
            }else{
                right++;
            }
        }
        
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        return result;
        
    }
}