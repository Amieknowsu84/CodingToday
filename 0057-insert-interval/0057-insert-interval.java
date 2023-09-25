class Solution {
    
//       -------
//     -----     ------- 
//     1 2 3 4 5 6 7 8 9
          
//           -------
//     -----     ------- 
//     1 2 3 4 5 6 7 8 9
         
//     -------
//      -----    ------- 
//     1 2 3 4 5 6 7 8 9       
        
    public int[][] insert(int[][] intervals, int[] newInterval) {
          
        
      ArrayList<int[]> res = new ArrayList<>();
      int current[]= new int[2];
      int [][] result =  new int[res.size()][];
      
      if(intervals.length == 0){
          result =  new int[1][];
          result[0] = newInterval;
          return result;
      }
      current[0]=intervals[0][0];
      current[1]=intervals[0][1];
      boolean merged = false; 
          
      if(newInterval[1]<current[0]){
          res.add(newInterval);
          merged = true;
      }   
      
         
          
      for(int i=0; i<intervals.length;i++){
          
          if((newInterval[0] >= current[0] && newInterval[0] <= current[1])||
            (current[0] >= newInterval[0] && current[0] <= newInterval[1])){
              current[0]=Math.min(current[0],newInterval[0]);
              current[1]=Math.max(current[1],newInterval[1]);   
              merged =  true;
          }
          
          if((intervals[i][0] >= current[0] && intervals[i][0] <= current[1])||
             (current[0] >= intervals[i][0] && current[0] <= intervals[i][1])){
              current[0]=Math.min(current[0],intervals[i][0]);
              current[1]=Math.max(current[1],intervals[i][1]); 
          }
          else{
              res.add(Arrays.copyOf(current,current.length));
              if(current[1]<newInterval[0] && intervals[i][0]>newInterval[1]){
                  res.add(newInterval);
                  merged = true;
              }
              current[0]=intervals[i][0];
              current[1]=intervals[i][1];
          }
      }
      
    if((newInterval[0] >= current[0] && newInterval[0] <= current[1])||
            (current[0] >= newInterval[0] && current[0] <= newInterval[1])){
              current[0]=Math.min(current[0],newInterval[0]);
              current[1]=Math.max(current[1],newInterval[1]);
               res.add(current);
        merged = true;
     }else{
      res.add(Arrays.copyOf(current,current.length));   
    }
      if(!merged){
            res.add(newInterval);
      }    
          
      result =  new int[res.size()][];
          
      for(int i=0;i<result.length;i++){
          result[i]=res.get(i);
      }    
          
      return result;    
          
    }
}