class Solution {

    public int largestRectangleArea(int[] heights) {
        int[] left=nseLeft(heights);
        int[] right=nseRight(heights);
        int maxArea=0;
         
        for(int i=0;i<heights.length;i++){
            int maxLeft=left[i];
            int maxRight=right[i];
            int value=(maxRight-maxLeft-1)*heights[i];
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