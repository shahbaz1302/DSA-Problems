class MyStack {
    Queue<Integer> queue;
    int size;

    public MyStack() {
        queue=new ArrayDeque<>();
        size=0;
    }
    
    public void push(int x) {
        queue.add(x);
        for(int i=0;i<size;i++){
            queue.add(queue.poll());
        }
        size++;
    }
    
    public int pop() {
        if(empty()) return -1;
        size--;
        return queue.poll();
    }
    
    public int top() {
        if(empty()) return -1;
        return queue.peek();
    }
    
    public boolean empty() {
        return size==0;
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