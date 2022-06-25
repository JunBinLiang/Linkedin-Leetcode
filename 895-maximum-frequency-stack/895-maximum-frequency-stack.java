//1. frequency  2. close to top
class FreqStack {
    Map<Integer, Stack<Integer>> f = new HashMap<>();
    
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
        if(y[0] == x[0]) {
            return y[1] - x[1];
        }
        return y[0] - x[0];
    }); //stack : [size, topIdx]
    int idx = 0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        if(!f.containsKey(val)) {
            f.put(val, new Stack<>());
        }
        Stack<Integer> sta = f.get(val);
        sta.push(idx);
        pq.add(new int[]{sta.size(), idx, val}); 
        idx++;
        
    }
    
    public int pop() {
        while(true) {
            int top[] = pq.peek();
            int size = top[0], topIdx = top[1], val = top[2];
            Stack<Integer> sta = f.get(val);
            if(size != sta.size() || topIdx != sta.peek()) {
                pq.poll();
                continue;
            }
            break;
        }
        
        int pair[] = pq.peek();
        int val = pair[2];
        Stack<Integer> sta = f.get(val);
        sta.pop();
        if(sta.size() > 0) {
            pq.add(new int[]{sta.size(), sta.peek(), val});
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */