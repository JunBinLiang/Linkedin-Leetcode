class Solution {
    public int minPathSum(int[][] a) {
        int n = a.length, m = a[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) continue;
                //[i, j]
                //a[i - 1][j]
                //a[i][j - 1]
                int min = Integer.MAX_VALUE;
                if(i - 1 >= 0) min = Math.min(min, a[i - 1][j]);
                if(j - 1 >= 0) min = Math.min(min, a[i][j - 1]);
                a[i][j] += min; 
            }
        }
        return a[n - 1][m - 1];
    }
}

/*
class Solution {
    public int minPathSum(int[][] a) {
        int n = a.length, m = a[0].length;
        return dfs(a, n - 1, m - 1);
    }
    
    public int dfs(int a[][], int r, int c) {
        if(r < 0 || c < 0) return 1000000000;
        if(r == 0 && c == 0) {
            return a[r][c];
        }
        return a[r][c] + Math.min(dfs(a, r - 1, c), dfs(a, r, c - 1));
    }
    
}
*/