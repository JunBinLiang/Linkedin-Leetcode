class Solution {
    public int[][] merge(int[][] a) { 
        Arrays.sort(a, (x, y) -> {
            return x[0] - y[0];
        });
        Stack<int[]> sta = new Stack<>();
        for(int p[] : a) {
            if(sta.size() == 0) {
                sta.push(p);
            } else {
                int peek[] = sta.peek();
                if(p[0] <= peek[1]) { //merge
                    peek[1] = Math.max(peek[1], p[1]);
                } else {
                    sta.push(p);
                }
            }
        }
        
        int res[][] = new int[sta.size()][2];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = sta.pop();
        }
        return res;
    }
}