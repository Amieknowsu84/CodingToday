class Solution {
    static long trapWater(int[] heights){
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        long area = 0;

        fillLeft(left, heights);
        fillRight(right, heights);

        for (int i = 1; i < heights.length - 1; i++) {
            int li = left[i];
            int ri = right[i];
            if (li >= 0 && ri >=0) {
                //System.out.println(i+" "+li+" "+ri);
                int height = Math.min(li,ri) - heights[i];
                int width = 1; // fix the width calculation
                //System.out.println("width "+width);
                //System.out.println("height "+height);
                area += height * width>0?height*width:0;
            }
        }
        
        return area; // add the missing return statement
    } 
    
      static void fillLeft(int[] left,int heights[]){
       // Arrays.stream(heights).forEach((h)->System.out.print(h+" ")); 
        int result = -1;
        for(int i=0;i<left.length;i++){
            left[i] = result;
            result = Math.max(result,heights[i]);
            //System.out.print(left[i]+" ");
        }
        //System.out.println();
    }
     
 //     0 1 2 3 4 5 6 7 8 9 10 11
//    [0,1,0,2,1,0,1,3,2,1,2, 1]
 //   -1-1 1-1 3 4 3-1 7 8 7  10
//     1 3 3 7 7 6 7 12 12 10 12 12
           

    
    static void fillRight(int[] right,int[] heights){
        
        int result = -1;
        for(int i=right.length-1; i>=0; i--){
           right[i] = result;  
           result = Math.max(result,heights[i]); 
        }
       // Arrays.stream(right).forEach((h)->System.out.print(h+" ")); 
        //System.out.println();
        
    }


    public int trap(int[] height) {
       return (int)trapWater(height);
    }
}