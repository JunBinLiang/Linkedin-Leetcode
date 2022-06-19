class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean dp[][][] = new boolean[n + 1][n + 2][n + 2];
        dp[0][0][0] = true;
        for(int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            for(int open = 0; open <= n; open++) {
                for(int close = 0; close <= open; close++) {
                    if(c == '(') {
                        dp[i][open + 1][close] |= dp[i - 1][open][close];
                    }
                    if(c == ')') {
                        if(close + 1 <= open) {
                            dp[i][open][close + 1] |= dp[i - 1][open][close];
                        }
                    }
                    
                    if(c == '*') {
                        dp[i][open + 1][close] |= dp[i - 1][open][close];
                        dp[i][open][close] |= dp[i - 1][open][close];
                        if(close + 1 <= open) {
                            dp[i][open][close + 1] |= dp[i - 1][open][close];
                        }
                    }
                }
            }
        }
        
        
        for(int i = 0; i <= n; i++) {
            if(dp[n][i][i]) {
                return true;
            }
        }
        
        return false;
    }
}