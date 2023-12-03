class Solution {
    // 0123
    // YYNY
    // 1223
    // [0,0,0,1,1]
    // [3,2,1,1,0]   
    
//     cntC = 1  minindex = 2
//     cntO = 1   minVal = 1
        
    public int bestClosingTime(String customers) {
        int cntC=0;
        int cntO=0;
        
        for(int i=0; i<customers.length(); i++){
            if(customers.charAt(i)=='Y')
                cntC++;
        }
        
        int minIndex = 0;
        int minValue = cntC;
        int currentCnt = 0;
        
        
        for(int i = 0; i <= customers.length(); i++){
         
            currentCnt = cntO + cntC;
            if(currentCnt < minValue){
                minValue = currentCnt;
                minIndex = i;
            }
            
            if(i!=customers.length() && customers.charAt(i) == 'N'){
                cntO++;
            }else{
                cntC--;
            }            

        }
    
        return minIndex;
        
    }
}