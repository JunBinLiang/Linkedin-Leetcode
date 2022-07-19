class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[amount + 1][coins.length + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= coins.length; i++) {
            int val = coins[i - 1];
            for(int sum = 0; sum < dp.length; sum++) {
                dp[sum][i] += dp[sum][i - 1];
                if(sum - val >= 0) {
                    dp[sum][i] += dp[sum - val][i];
                }
            }
        }
        return dp[amount][coins.length];
    }
    
    /*public int dfs(int a[], int sum, int i) {
        if(i < 0) {
            if(sum == 0) return 1;
            else return 0;
        }
        
        if(dp[sum][i] != -1) return dp[sum][i];
        
        int res = 0;
        res += dfs(a, sum, i - 1);
        if(sum >= a[i]) {
            res += dfs(a, sum - a[i], i);
        }
        return dp[sum][i] = res;
    }*/
    
    //dp[sum][i] = dp[sum - a[i]][i] + dp[sum][i - 1]
}