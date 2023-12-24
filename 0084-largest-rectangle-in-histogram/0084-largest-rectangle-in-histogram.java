import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = nseL(heights);
        int[] right = nseR(heights);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int value = (right[i] - left[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, value);
        }

        return maxArea;
    }
    
    private int[] nseL(int heights[]){
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[heights.length];
        int index = -1, currentIndex = -1;
        
        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        
        return result;
    }
    
    private int[] nseR(int heights[]){
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[heights.length];
        
        for(int i=heights.length-1 ; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }
        
        return result;
    }
    
    

    private int[] nse(int[] heights, boolean isLeft) {
        Stack<Integer> indexes = new Stack<>();
        int[] res = new int[heights.length];
        int n = heights.length;


        int start = isLeft ? 0 : n - 1;
        int end = isLeft ? n : -1;
        int step = isLeft ? 1 : -1;

        for (int i = start; i != end; i += step) {
            while (!indexes.isEmpty() && heights[indexes.peek()] >= heights[i]) {
                indexes.pop();
            }

            res[i] = isLeft ? (indexes.isEmpty() ? 0 : indexes.peek() + 1) : (indexes.isEmpty() ? n : indexes.peek());

            indexes.push(i);
        }

        return res;
    }
}
