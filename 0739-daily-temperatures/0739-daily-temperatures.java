class Solution {
   //  0  1  2  3  4  5  6  7
    //[73,74,75,71,69,72,76,73]
    
    //  0  1  2  3
    //[73,72,71,71]
    
    //  0  1  2  3
    //[73,74,75]
    
    
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temp.length];
        for(int i=0;i<temp.length;i++){
            while(!st.isEmpty() && temp[st.peek()]<temp[i]){
                    int index = st.pop();
                    res[index] = i-index;
            }
            st.push(i);
        }
        
        return res;
    }
}