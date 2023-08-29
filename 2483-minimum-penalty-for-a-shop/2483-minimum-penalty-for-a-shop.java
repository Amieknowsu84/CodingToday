class Solution {
    // 0123
    // YYNY
    // 1223
    // [0,0,0,1,1]
    // [3,2,1,1,0]    
        
    public int bestClosingTime(String customers) {
        int open[]=new int[customers.length()+1];
        int closed[]=new int[customers.length()+1];
        int ncnt=0;
        for(int i=0;i<customers.length();i++){
            open[i]=ncnt;
            if(customers.charAt(i)=='N')
                ncnt++;
        }
        open[open.length-1]=ncnt;
        
        int ycnt=0;
        closed[closed.length-1]=ycnt;
        for(int i=customers.length()-1 ; i>=0 ;i--){
            if(customers.charAt(i)=='Y')
                ycnt++;
             closed[i]=ycnt;
        }
        int min=Integer.MAX_VALUE;
        int index=-1;
         for(int i=0 ; i<open.length ;i++){
             //System.out.println(open[i]+" "+closed[i]);
             if(min > open[i]+closed[i]){
                 min = open[i]+closed[i];
                 index=i;
             }
         }
        return index;
    }
}