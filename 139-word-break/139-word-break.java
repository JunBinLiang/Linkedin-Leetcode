class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];
        for(int i = 0; i < s.length();i++) {
            for(String w : wordDict) {
                if(i + 1 >= w.length() && w.equals(s.substring(i - w.length() + 1, i + 1))) {
                    if(i - w.length() < 0 || dp[i - w.length()]) {
                        dp[i] = true;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        
        return dp[s.length() - 1];
    }
}

//leet   code
//       code