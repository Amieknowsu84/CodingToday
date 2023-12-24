class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int[][] positionSpeed = new int[position.length][2];
        
        for(int i=0; i<position.length; i++){
            positionSpeed[i] = new int[2];
            positionSpeed[i][0] = position[i];
            positionSpeed[i][1] = speed[i];
        }
        
        Arrays.sort(positionSpeed,(a,b)->Integer.compare(a[0],b[0]));
        
        Stack<int[]> stack= new Stack<>();
        stack.push(positionSpeed[positionSpeed.length-1]);
        
        for(int i=positionSpeed.length-2 ; i>=0 ; i--){
            
            int[] peekElement=stack.peek();
            double peekElemtime = (double)(target-peekElement[0])/peekElement[1];
            double currentElemtime = (double)(target-positionSpeed[i][0])/positionSpeed[i][1];
        
            if(currentElemtime > peekElemtime){
               stack.push(positionSpeed[i]);
            }
        }
    
        return stack.size();
    }   
}