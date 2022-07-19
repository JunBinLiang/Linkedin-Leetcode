class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length + 1];
        for(int p[] : dp) Arrays.fill(p, -1);
        return dfs(coins, amount, coins.length - 1);
    }
    
    public int dfs(int a[], int sum, int i) {
        if(i < 0) {
            if(sum == 0) return 1;
            else return 0;
        }
        
        if(dp[sum][i] != -1) return dp[sum][i];
        
        int res = 0;
        res += dfs(a, sum, i - 1);
        if(sum >= a[i]) {
            res += dfs(a, sum - a[i], i);
            //res += dfs(a, sum - a[i], i - 1);
        }
        //System.out.println(sum + " " + i + " " + res);
        return dp[sum][i] = res;
    }
}