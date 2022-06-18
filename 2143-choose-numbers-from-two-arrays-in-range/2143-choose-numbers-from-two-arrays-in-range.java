class Solution {
    int mod = 1000000007;
    int dp[][][];
    public int countSubranges(int[] a, int[] b) {
        int n = a.length;
        long res = 0;
        dp = new int[n][10000 + 5][2];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        for(int i = 0; i < a.length; i++) {
            res += dfs(a, b, i, 0);
            res--;
            res += mod;
            res %= mod;
        }
        return (int)(res);
    }
    
    public int dfs(int a[], int b[], int i, int sum) {
        if(i >= a.length) {
            if(sum == 0) return 1;
            return 0;
        }
        int state = 0;
        if(sum < 0) state = 1;
        if(dp[i][Math.abs(sum)][state] != -1) {
            return dp[i][Math.abs(sum)][state];   
        }
        
        int res = 0;
        if(sum == 0) res++;
        
        res += dfs(a, b, i + 1, sum + a[i]);
        res %= mod;
        res += dfs(a, b, i + 1, sum - b[i]);
        res %= mod;
        return dp[i][Math.abs(sum)][state] = res;
    }
}