class Solution {
    
    // [1,1,1,2,2,3]
    // index=4
    // current = 3    
    // cnt = 1
    // [1,1,2,2,3]    
    
  public int removeDuplicates(int[] nums) {
    int length = nums.length;
    
    if (length <= 2) {
        return length;
    }
    
    int index = 2; // Start from the third element
    for (int i = 2; i < length; i++) {
        if (nums[i] != nums[index - 2]) {
            nums[index++] = nums[i];
        }
    }
    
    return index;
  }

}