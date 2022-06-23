class Solution {
    List<Integer> dp[][];
    public List<Integer> diffWaysToCompute(String s) {
        dp = new ArrayList[s.length()][s.length()];
        return dfs(s, 0, s.length() - 1);
    }
    
    public List<Integer> dfs(String s, int l, int r) {
        List<Integer> res = new ArrayList<>();
        if(dp[l][r] != null) return dp[l][r]; 
        
        for(int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = dfs(s, l, i - 1);
                List<Integer> right = dfs(s, i + 1, r);
                for(int x : left) {
                    for(int y : right) {
                        if(c == '+')res.add(x + y);
                        if(c == '*')res.add(x * y);
                        if(c == '-')res.add(x - y);
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(Integer.parseInt(s.substring(l, r + 1)));
        }
        return dp[l][r] = res;
    }
}