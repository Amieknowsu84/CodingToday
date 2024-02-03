class Solution {
    
      //0 1  2 3 4 5 6 
     //[1,15,7,9,2,5,10]
          
          
     //15,13,11,2,1,9,8     
          
          
          
    public int maxSumAfterPartitioning(int[] arr, int k) {
       // 1 15 7 9 2 5 10
        Integer dp[] = new Integer[arr.length];
        return partition(0,arr,k,dp);
    }
    
    int partition(int si,int[] arr,int k,Integer dp[]){
        if(si >= arr.length){
             return 0;  
        }
        
        if(dp[si]!=null){
            return dp[si];
        }
        
        int csum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        //System.out.println(si+" -- "+csum);
        for(int i=si;i<Math.min(arr.length,si+k);i++){
            max = Math.max(max,arr[i]);
            //System.out.println(si+" "+" "+i+" "+max);
            csum = Math.max(csum,(i-si+1)*max + partition(i+1,arr,k,dp));
        }
        //System.out.println(si+" - "+csum);
        return dp[si]=csum;
    }
}