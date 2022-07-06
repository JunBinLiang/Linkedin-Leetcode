class Solution {
    public int minDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j - 1] + 2, dp[i][j - 1] + 1));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[n][m];
    }
}