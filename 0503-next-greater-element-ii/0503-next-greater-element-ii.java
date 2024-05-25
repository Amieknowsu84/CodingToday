class Solution {
    
     //   0 1 2 3 4
     //  [1,2,3,4,3]
    // idea is to use stack and to find the next greater element 
    // store it in linearly decreasing pattern whenever found an element
    // greater than the element in stack it should be next greater element
    // since it is circular we need to look into the entire array again.
    
     //   0 1 2 3 4
     //  [1,2,3,4,3]
     //  [2,3,4,-1,4]    
    
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        
        Stack<Integer> stack = new Stack<>();
        
        int size = nums.length * 2;
        
        for(int i = 0; i < size; i++){
           int currentIndex = i % nums.length;
           while(!stack.isEmpty() && nums[stack.peek()] < nums[currentIndex]){
               int popIndex = stack.pop();
               result[popIndex] = nums[currentIndex];
           }
           stack.push(currentIndex); 
        }
        
        return result;
    }
}