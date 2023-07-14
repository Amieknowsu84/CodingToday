class Solution {
    
    public int longestSubsequence(int[] arr, int difference) {
       HashMap<Integer,Integer> hm=new HashMap<>();
        int tmax=0;
        for(int i=arr.length-1;i>=0;i--){
            int curr=1+hm.getOrDefault(arr[i]+difference,0);
            hm.put(arr[i],curr);
            tmax=Math.max(tmax,curr);
        }
        
       return tmax;
    }      
    
}