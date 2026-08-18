class MinStack {
    Stack<Long> stack;
    long min = Long.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        long val=(long) value;
        if (stack.isEmpty()) {
            min = val;
            stack.push(val);
        } else {
            if (value > min)
                stack.push(val);
            else {
                stack.push(2 * val - min);
                min = val;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        long x = stack.pop();
        if (x < min)
            min = 2 * min - x;
    }

    public int top() {
        if (stack.isEmpty())
            return -1;
        long x = stack.peek();
        if (min < x)
            return (int)x;
        return (int)min;
    }

    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */