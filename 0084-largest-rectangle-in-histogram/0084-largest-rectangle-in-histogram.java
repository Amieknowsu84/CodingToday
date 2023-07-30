class Solution {
   //   0 1   2 3 4 5
   //  [2, 1, 5,6,2,3]
   // nse left[-1,-1,1,2,1,4]
   // nse right[1,-1,4,4,-1,-1]
    public int largestRectangleArea(int[] heights) {
        int[] left=nseLeft(heights);
        int[] right=nseRight(heights);
//         String result1 = Arrays.stream(left)
//             .mapToObj(String::valueOf)
//             .collect(Collectors.joining(" "));
        
//         System.out.println(result1);
        
//         String result2 = Arrays.stream(right)
//             .mapToObj(String::valueOf)
//             .collect(Collectors.joining(" "));
        
//        System.out.println(result2);


         int maxArea=0;
         
        for(int i=0;i<heights.length;i++){
            int maxLeft=left[i];
            int maxRight=right[i];
            int value=(maxRight-maxLeft-1)*heights[i];
            //System.out.println(value);
            maxArea= Math.max(maxArea,value);
        } 
         
         return maxArea;
         
    }
    
    
      
     int[] nseLeft(int[] heights){
        Stack<Integer> indexes=new Stack<>();
        int[] res=new int[heights.length];
        
        for(int i=0;i<heights.length;i++){
            if(indexes.isEmpty()){
                indexes.push(i);
                res[i]=0;
            }else{
                  int ind=-1;
                while(!indexes.isEmpty()){
                    ind=indexes.peek();
                    if(heights[ind]>=heights[i]){
                       indexes.pop();
                    }else{
                        break;
                    }
                }
               
                if(indexes.isEmpty()){
                    res[i]=0;
                }else{
                    res[i]=ind+1;
                }
                 indexes.push(i);
            }
        }
        
        return res;       
    }
    
    
     int[] nseRight(int[] heights){
        Stack<Integer> indexes=new Stack<>();
        int[] res=new int[heights.length];
        
        for(int i=heights.length-1;i>=0;i--){
            if(indexes.isEmpty()){
                indexes.push(i);
                res[i]=heights.length+1;
            }else{
                int ind=-1;
                while(!indexes.isEmpty()){
                    ind=indexes.peek();
                    if(heights[ind]>=heights[i]){
                       indexes.pop();
                    }else{
                        break;
                    }
                }

                if(indexes.isEmpty()){
                    res[i]=heights.length+1;
                }else{
                    res[i]=ind+1;
                }
                indexes.push(i);
            }
        }
        
        return res;       
    }
    
    
}