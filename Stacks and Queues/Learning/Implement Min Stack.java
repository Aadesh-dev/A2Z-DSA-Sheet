class MinStack {
    Stack<Pair> s;

    public MinStack() {
        s  = new Stack<>();
    }
    
    public void push(int val) {
        Pair pair;
        if(s.isEmpty()) {
            pair = new Pair(val, val);
        } else {
            int min = getMin();
            pair = new Pair(val, val < min ? val : min);
        }
        s.push(pair);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return (int) s.peek().getKey();
    }
    
    public int getMin() {
        return (int) s.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//Time: O(1), Space: O(1)

