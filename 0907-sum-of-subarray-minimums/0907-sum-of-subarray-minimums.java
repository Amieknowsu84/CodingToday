
class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        int n = arr.length;
        long result = 0;

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        // Calculate the left boundary of the minimum element for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for calculating the right boundary
        stack.clear();

        // Calculate the right boundary of the minimum element for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the contribution of each element to the result
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * (i - left[i]) * (right[i] - i) % MOD) % MOD;
        }

        return (int) result;
    }
}
