class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[amount + 1][coins.length + 1];
        for(int p[] : dp) Arrays.fill(p, 100000000);
        dp[0][0] = 0;
        
        for(int i = 1; i <= coins.length; i++) {
            int val = coins[i - 1];
            for(int sum = 0; sum < dp.length; sum++) {
                dp[sum][i] = Math.min(dp[sum][i], dp[sum][i - 1]);
                if(sum - val >= 0) {
                    dp[sum][i] = Math.min(dp[sum][i], 1 + dp[sum - val][i]);
                }
            }
        }
        int res = dp[amount][coins.length];
        if(res >= 100000000) return -1;
        return res;
    }
    
    /*public int dfs(int a[], int sum, int i) {
        if(i < 0) {
            if(sum == 0) return 0;
            else return 100000000;
        }
        
        if(dp[sum][i] != -1) return dp[sum][i];
        
        int res = 100000000;
        
        res = Math.min(res, dfs(a, sum, i - 1));
        if(sum >= a[i]) {
            res = Math.min(res, 1 + dfs(a, sum - a[i], i)) ;
        }
        return dp[sum][i] = res;
    }*/
    
    //dp[sum][i] = min(1 + dp[sum - a[i]][i], dp[sum][i - 1])
}