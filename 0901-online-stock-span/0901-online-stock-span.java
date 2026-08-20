class StockSpanner {
    Stack<int[]> stack;
    int index=-1;

    public StockSpanner() {
        index=-1;
        stack=new Stack<>();
    }

    public int next(int price) {
        index++;
        while(!stack.isEmpty() && price>=stack.peek()[0]) stack.pop();
        int ans=index-(stack.isEmpty()?-1:stack.peek()[1]);
        stack.push(new int[]{price,index});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */