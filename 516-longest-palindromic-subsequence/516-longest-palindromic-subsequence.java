class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        if(i + 1 < n && j - 1 >= 0 && i + 1 <= j - 1)dp[i][j] = 2 + dp[i + 1][j - 1];
                        else dp[i][j] = Math.max(dp[i][j], 2);
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }
}