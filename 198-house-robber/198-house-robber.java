class Solution {
    public int rob(int[] a) {
        int n = a.length;
        int dp[] = new int[n];
        
        dp[0] = a[0];
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            int add = 0;
            if(i - 2 >= 0) add = dp[i - 2];
            dp[i] = Math.max(dp[i], a[i] + add);
        }
        
        return dp[n - 1];
    }
}