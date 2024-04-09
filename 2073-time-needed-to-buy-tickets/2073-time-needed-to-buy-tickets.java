class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
         int cnt = 0;
         int secs = 0;
         while(tickets[k]!=0){
             for(int i=0;i<tickets.length;i++){
                 if(tickets[i] != 0){
                     secs++;
                     tickets[i]--;
                 }
                 if(i==k && tickets[k] == 0){
                     return secs;
                 }
             }
         }
        
        return secs;
    }
}