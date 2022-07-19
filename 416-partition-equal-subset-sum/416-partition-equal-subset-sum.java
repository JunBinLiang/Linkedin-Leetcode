class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] a) {
        int sum = 0;
        for(int i : a) sum += i;
        if(sum % 2 == 1) return false;
        sum /= 2;
        dp = new Boolean[sum + 1][a.length + 1];
        return dfs(a, sum, 0);
    }
    
    public boolean dfs(int a[], int sum, int i) {
        if(i >= a.length) {
            if(sum == 0) return true;
            else return false;
        }
        
        if(dp[sum][i] != null) return dp[sum][i];
        
        boolean res = false;
        if(sum - a[i] >= 0) {
            boolean x = dfs(a, sum - a[i], i + 1);
            if(x) res = true;
        }
        boolean y = dfs(a, sum, i + 1);
        if(y) res = true;
        dp[sum][i] = res;
        return res;
    }
    
}