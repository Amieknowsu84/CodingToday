class StockSpanner{
    
    // next greater element to the left
    //  [7,2,1,2]
    //   1              [7]
    //   1 1            [7,2]
    //   1 1 1          [7,2,1]
    //   1 1 1 3        [7] 
    Stack<Pair<Integer,Integer>> stack;
    int cnt;
    
    public StockSpanner() {
        stack = new Stack<>();
        cnt = 0;
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek().getValue() <= price){
            stack.pop();
        }
        cnt++;
        int ans = stack.isEmpty()?cnt:(cnt-stack.peek().getKey());
        stack.push(new Pair<>(cnt,price));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */