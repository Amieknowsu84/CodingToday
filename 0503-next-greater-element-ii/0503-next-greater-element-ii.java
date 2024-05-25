
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);  // Initialize result array with -1

        Stack<Integer> stack = new Stack<>();

        int size = nums.length;
        
        // Iterate twice over the array to handle the circular nature
        for (int i = 0; i < 2 * size; i++) {
            int currentIndex = i % size;  // Current index in the array
            
            // Process current element against the elements in the stack
            while (!stack.isEmpty() && nums[stack.peek()] < nums[currentIndex]) {
                int popIndex = stack.pop();
                result[popIndex] = nums[currentIndex];
            }
            
            // Only push the index of the first pass to avoid redundant indices
            if (i < size) {
                stack.push(currentIndex);
            }
        }
        
        return result;
    }
}
