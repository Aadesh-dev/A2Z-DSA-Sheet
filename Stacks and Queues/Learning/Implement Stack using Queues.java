//Single queue brute force
class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(queue.poll());
        }
        queue.add(x);
        for(int n : list) {
            queue.add(n);
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//Time: O(n), Space: O(n)

//Two queues brute force
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue2.add(x);
        while(!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}
//Time: O(n), Space: O(n)

//Single queue optimal
class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        for(int i = 1; i < queue.size(); i++) {
            queue.add(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
//Time: O(n), Space: O(1)