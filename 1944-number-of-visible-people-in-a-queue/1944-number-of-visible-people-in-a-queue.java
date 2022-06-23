class Solution {
    public int[] canSeePersonsCount(int[] a) {
        int n = a.length;
        int res[] = new int[n];
        Stack<Integer> sta = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(sta.size() == 0) {
                sta.push(i);
            } else {
                while(sta.size() > 0 && a[i] >= a[sta.peek()]) {
                    int idx = sta.pop();
                    res[idx]++;
                }
                if(sta.size() > 0) res[sta.peek()]++;
                sta.push(i);
            }
        }
        

        
        return res;
    }
}