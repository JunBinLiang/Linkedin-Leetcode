class Solution {

    public boolean canPartition(int[] a) {
        int sum = 0;
        for(int i : a) sum += i;
        if(sum % 2 == 1) return false;
        sum /= 2;
        
        boolean dp[][] = new boolean[sum + 1][a.length + 1];
        dp[0][0] = true;
        
        for(int i = 1; i <= a.length; i++) {
            int val = a[i - 1];
            for(int j = 0; j < dp.length; j++) {
                dp[j][i] |= dp[j][i - 1];
                if(j >= val) {
                    dp[j][i] |= dp[j - val][i - 1];
                }
            }
        }
  
        return dp[sum][a.length];
    }
    
    /**public boolean dfs(int a[], int sum, int i) {
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
    }**/
    
    //dp[sum][i] = dp[sum - a[i]][i - 1] | dp[sum][i - 1] 
    
}