class Solution {
    public long putMarbles(int[] weights, int k) {
        
        if(k==weights.length){
            return 0;
        }
        
        long min=weights[0]+weights[weights.length-1];
        long max=min;
        
        ArrayList<Long> list=new ArrayList<>();
        
        for(int i=1;i<weights.length;i++){
            
            long newStartPoint=weights[i];
            long lastEndPoint=weights[i-1];
            list.add(newStartPoint+lastEndPoint);
            
        }
    
        Collections.sort(list);
        
        for(int i=0;i<k-1;i++){
            min+=list.get(i);
        }
        
        int lastIndex=list.size()-1;
        for(int j=0;j<k-1;j++){
            max+=list.get(lastIndex-j);
        }
        
        return max-min;
        
    }
}