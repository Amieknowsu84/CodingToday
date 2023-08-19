class KthLargest {
    
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        
        for(int num:nums){
            pq.add(num);
            removeElement();
        }
        
    }
    
    void removeElement(){
        if(pq.size()>k){
           pq.remove();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        removeElement();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */