class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = (position[position.length-1]-position[0])/(m-1);
        
        int ans = -1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            //System.out.println(mid);
            if(canPlace(position,m,mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return ans;
    }
    
    
    boolean canPlace(int[] position,int m,int minF){
        int lastPlaced = 0;
        int count = 1;
        
        for(int i=1; i<position.length; i++){
           if(position[i]-position[lastPlaced]>=minF){
               count++;
               lastPlaced = i;
           }   
            
           if(count == m){
               return true;
           }   
        }
        
        return count == m ? true : false;
    }
}