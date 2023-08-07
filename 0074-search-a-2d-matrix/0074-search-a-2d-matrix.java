class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_M = matrix.length;
        int col_N = matrix[0].length;
        if( target < matrix[0][0] ||  target > matrix[row_M-1][col_N-1])
            return false; 

        int l= 0, r= row_M*col_N-1 ;
        while ( l <= r ) {  
            int mid = l+(r-l)/2;  
            int mid_val = matrix[mid/col_N][mid%col_N];
            if( mid_val == target ) 
                return true;
            if( target < mid_val ) 
                r = mid-1;
            if( mid_val < target )
                l = mid+1; 
        }

        return false; 
    }
}