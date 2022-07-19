class Solution {
     int dp[][];
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1][coins.length + 1];
        for(int p[] : dp) Arrays.fill(p, -1);
        int res =  dfs(coins, amount, coins.length - 1);
        if(res >= 100000000) return -1;
        return res;
    }
    
    public int dfs(int a[], int sum, int i) {
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
    }
}