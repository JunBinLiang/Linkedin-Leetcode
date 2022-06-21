class Solution {
    public int minCost(int[][] a) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                int mn = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++) {
                    if(k != j) mn = Math.min(mn, a[i - 1][k]);
                }
                a[i][j] += mn;
            }
        }
        
        
        return Math.min(a[n - 1][0], Math.min(a[n - 1][1], a[n - 1][2]));
    }
}