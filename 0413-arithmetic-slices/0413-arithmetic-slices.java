class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
   if(arr.length < 3){
        return  0;    
  }
    
   int diff = arr[1]-arr[0];
   int cnt =2;
   ArrayList<Integer> list = new ArrayList<>();     
   
  for(int i = 2; i< arr.length; i++){
      int currDiff = arr[i]-arr[i-1];
      if(currDiff == diff){
         cnt++; 
      }else{
         if(cnt >= 3){
           list.add(cnt);
         }
         cnt = 2;
         diff = currDiff;
      }   
   }
   if(cnt >= 3){
           list.add(cnt);
  }     
        
    int result = 0;
    for(int i=0; i<list.size();i++){
        System.out.println(list.get(i));
        int k = list.get(i)- 3 +1;
        result += (k*(k+1)/2);
    }
        
    return result;    

}    
    
}