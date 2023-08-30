
  class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;  
        long operations = 0;  

        // Iterate through the array in reverse order (from second-to-last to first element)
        for (int i = n - 2; i >= 0; i--) {
            // If the current element is smaller than or equal to the next element, no action needed
            if (nums[i] <= nums[i + 1]) {
                continue;  
            }

            // Calculate how many parts the current element needs to be divided into to be smaller than or equal to the next element
            int parts = nums[i] / nums[i + 1];
            if (nums[i] % nums[i + 1] != 0) {
                // If there's a remainder, an extra part is needed
                parts += 1;  
            }
            // Increment the operation count by parts minus 1
            operations += parts - 1;  
         // Update the current element to a reduced value
            nums[i] = nums[i] / parts; 
        }
        // Return the total number of operations performed
        return operations;  
    }
}
