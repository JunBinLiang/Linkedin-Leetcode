class Solution {
    public boolean canPartition(int[] a) {
        int sum = 0;
        for(int i : a) sum += i;
        if(sum % 2 == 1) return false;
        sum /= 2;
       
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;
        
        for(int val : a) {
            for(int i = dp.length - 1; i >= 0; i--) {
                if(i >= val && dp[i - val]) {
                   dp[i] = true;
                }
            }
        }
        return dp[sum];
    }
    
    /*public boolean dfs(int a[], int sum, int i) {
        if(i < 0) {
            if(sum == 0) return true;
            else return false;
        }
        
        if(dp[sum][i] != null) return dp[sum][i];
        
        boolean res = false;
        if(sum - a[i] >= 0) {
            boolean x = dfs(a, sum - a[i], i - 1);
            if(x) res = true;
        }
        boolean y = dfs(a, sum, i - 1);
        if(y) res = true;
        dp[sum][i] = res;
        return res;
    }*/
    
}