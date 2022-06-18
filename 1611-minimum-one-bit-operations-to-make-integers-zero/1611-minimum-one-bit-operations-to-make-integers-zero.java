class Solution {
    int dp1[] = new int[31];
    int dp2[] = new int[31];
    public int minimumOneBitOperations(int n) {
        if(n == 1) {
            return 1;
        }
        
        dp1[0] = 1; //100000 into 0
        dp1[1] = 3;// 0 into 100000
        dp2[0] = 1;
        dp2[1] = 3;
        for(int i = 2; i < 31; i++) {
            dp1[i] = dp1[i - 1] + 1 + dp2[i - 1];
            dp2[i] = dp2[i - 1] + 1 + dp1[i - 1];
        }
        return dfs(n);
    }
    
    public int dfs(int n) {
        if(n <= 1) {
            return n;
        }
        int bit = -1;
        for(int i = 0; i < 31; i++) {
            if((n & (1 << i)) > 0) {
               bit = i; 
            }
        }
        return dp1[bit] - dfs(n ^ (1 << bit));
    }
}