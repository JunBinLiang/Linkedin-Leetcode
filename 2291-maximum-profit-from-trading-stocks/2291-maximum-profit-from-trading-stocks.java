class Solution {
    public int maximumProfit(int[] a, int[] b, int t) {
        int dp[] = new int[t + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int res = 0;
        for(int i = 0; i < a.length; i++) {
            for(int j = dp.length - 1; j >= 0; j--) {
                if(j >= a[i] && dp[j - a[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - a[i]] + (b[i] - a[i]));
                }
            }
        }
        for(int i : dp) res = Math.max(res, i);
        return res;
    }
}