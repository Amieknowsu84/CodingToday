import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            // Check if there are still rows left to traverse
            if (top <= bottom) {
                // Traverse bottom row
                for (int j = right; j >= left; j--)
                    result.add(matrix[bottom][j]);
                bottom--;
            }

            // Check if there are still columns left to traverse
            if (left <= right) {
                // Traverse left column
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }
}
