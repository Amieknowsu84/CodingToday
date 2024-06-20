class Solution {
    /*

A better maxForce value would be (p[n - 1] - p[0]) / (m - 1)

Let's say p[0]  is the first element in the array and x is the maxForce. Ideally maxForce should have been the common difference of an arithmetic progression ending at the last element of the sorted array. 

So assuming you included p[0] you need (m - 1) more values to make m baskets in total. 

The AP would look like p[0], p[0] + x, p[0] + 2x... p[0] + (m - 1)x

To make the best use of the whole array.. the last element of the series should be the last number in the array.. 
p[0] + (m - 1)x = p[n - 1]

Solve for x and you should get (p[n - 1] - p[0]) / (m - 1)
    */
    
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = (position[position.length-1]-position[0]);
        
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