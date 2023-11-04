class Solution {
    
//     [1,0,1,0,0]
    
//     [2,0,2,1,1]
//      0 1 2 3 4
    
//     [3,1,3,2,2]    [-1,-1,1,1,1]  [1,5,3,5,5]
//      0 1 2 3 4          [1,5,1,3,3]
       
//     nextSmallerElementToRight    
         
//     [1,3]
//     [0,1]     
         
//     [4,0,0,3,0]
//      0 1 2 3 4    
    
    public int maximalRectangle(char[][] matrix) {
         
         int curr[]=new int[matrix[0].length];
         
         int max = 0;
        
         for(int i=0; i<matrix.length; i++){
             for(int j=0; j<matrix[0].length; j++){
                 curr[j] = (matrix[i][j] == '0') ? 0: (1 + curr[j]);
             }
             
            max = Math.max(max,findMaxArea(curr)); 
            //Arrays.stream(curr).forEach(element -> System.out.print(element+" "));
             
            System.out.println(max);
         }
         
         return max;
    }
    
    
    int findMaxArea(int height[]){
        
       int left[] = new int[height.length];
       int right[] = new int[height.length];
        
       Stack<Integer> stack = new Stack<>();
        
       for(int i=0; i<height.length; i++){
           
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                   stack.pop();
             }
           
           if(!stack.isEmpty()){
               left[i] = stack.peek();
           }else{
               left[i] = -1;
           }
           stack.push(i);
       } 
        
       stack = new Stack<>(); 
       
        
       for(int i=height.length-1; i>=0; i--){
           
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                   stack.pop();
             }
           
           if(!stack.isEmpty()){
               right[i] = stack.peek();
           }else{
               right[i] = height.length;
           }
           stack.push(i);
       }
        
        
       int max = 0;
        
       for(int i=0; i<left.length;i++){
           int value = (right[i]-left[i]-1)*height[i];
           max= Math.max(max,value);
       }
        
       return max; 
    }
}