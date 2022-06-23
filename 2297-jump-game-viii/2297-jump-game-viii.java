class Solution {
    public long minCost(int[] a, int[] costs) {
        int n = a.length;
        long dp[] = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        Stack<Integer> sta1 = new Stack<>();
        Stack<Integer> sta2 = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(i > 0) dp[i] = dp[i - 1] + costs[i];
            if(sta1.size() == 0) {
                sta1.push(i);
            } else {
                while(sta1.size() > 0 && a[i] >= a[sta1.peek()]) {
                    int idx = sta1.pop();
                    dp[i] = Math.min(dp[i], costs[i] + dp[idx]);
                }
                sta1.push(i);
            }
            
            if(sta2.size() == 0) {
                sta2.push(i);
            } else {
                while(sta2.size() > 0 && a[i] < a[sta2.peek()]) {
                    int idx = sta2.pop();
                    dp[i] = Math.min(dp[i], costs[i] + dp[idx]);
                }
                sta2.push(i);
            }
        }
        
        return dp[n - 1];
    }
}