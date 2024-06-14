class Solution {
    public int minIncrementForUnique(int[] nums) {
       int max =  Arrays.stream(nums).max().getAsInt();
        //{0,0,0,4}
       int[] map = new int[200000];
        
       for(int num: nums){
           map[num]++;
       }
        
       int extra = 0;
        
       for(int i=0;i<map.length;i++){
           if(map[i] > 1){
               extra += map[i]-1; 
               map[i+1] += map[i]-1;
               map[i] = 1;
           }
       } 
        
       return extra; 
        
    }
}