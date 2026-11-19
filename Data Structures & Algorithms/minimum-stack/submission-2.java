class MinStack {

    private final Deque<Integer> values = new ArrayDeque<>();
    private final Deque<Integer> minimums = new ArrayDeque<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
    }
    
    public void push(int val) {
        values.push(val);
        min = Math.min(val,min);
        minimums.push(min);
    }
    
    public void pop() {
        values.pop();
        minimums.pop();

        if(!minimums.isEmpty()){
            min = minimums.peek();
        } else {
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return  minimums.peek();
    }
}
