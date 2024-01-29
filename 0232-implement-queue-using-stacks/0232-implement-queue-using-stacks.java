class MyQueue {
 
    Stack<Integer> input;
    Stack<Integer> output;
    
    public MyQueue() {
         input = new Stack();
         output = new Stack();
    }
    
    public void push(int x) {
         input.push(x);       
    }
    
    public int pop() {
       put();
       return output.pop();
    }
    
    public int peek() {
       put();
       return output.peek(); 
    }
    
    private void put(){
        if (output.empty())
           while (!input.empty())
             output.push(input.pop());
    }
    
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */