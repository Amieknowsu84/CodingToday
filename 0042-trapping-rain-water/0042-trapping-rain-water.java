class Solution {
    static long trapWater(int[] heights){
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int area = 0;

        fillLeft(left, heights);
        fillRight(right, heights);

        for (int i = 0; i < heights.length; i++) {
            int li = left[i];
            int ri = right[i];
            int heightOfWaterIthBuilding = Math.min(li,ri) - heights[i];
            //System.out.println(li+" "+ri+" "+heightOfWaterIthBuilding+" "+heights[i]);
            if(heightOfWaterIthBuilding > 0)
             area += heightOfWaterIthBuilding;
        }
        
        return area; 
    } 
    
      static void fillLeft(int[] left,int heights[]){
        int result = heights[0];
        for(int i=0;i<left.length;i++){
            left[i] = result;
            result = Math.max(result,heights[i]);
        }
    }
     
 //     0 1 2 3 4 5 6 7 8 9 10 11
//    [0,1,0,2,1,0,1,3,2,1,2, 1]
 //   -1-1 1-1 3 4 3-1 7 8 7  10
//     1 3 3 7 7 6 7 12 12 10 12 12
           
    
    static void fillRight(int[] right,int[] heights){
        int result = heights[heights.length-1];
        for(int i=right.length-1; i>=0; i--){
           right[i] = result;  
           result = Math.max(result,heights[i]); 
        }
    }


    public int trap(int[] height) {
       return (int)trapWater(height);
    }
}