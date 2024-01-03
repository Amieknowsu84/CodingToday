class Solution {
    public int numberOfBeams(String[] bank) {
        int totalcnt = 0,cnt1=-1,cnt2=-1,cnt = 0;
        boolean seen = false;
        
        for(String floor:bank){
            cnt = 0;
            for(int i=0; i<floor.length(); i++){
               if(floor.charAt(i) == '1'){
                   cnt++;
               }
            }
            
           // System.out.println(cnt);
            
            if(cnt1 == -1){
                cnt1 = cnt;
            }else if(cnt2 == -1 && cnt != 0){
                cnt2 = cnt;
                totalcnt+=(cnt1*cnt2);
                cnt1 = cnt;
                cnt2 = -1;
            }
            
        }
        
        return totalcnt;
        
        
    }
}