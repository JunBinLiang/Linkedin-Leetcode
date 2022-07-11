class Solution {
    public int minCostII(int[][] a) {
        int k = a[0].length;
        for(int i = 1; i < a.length; i++) {
            for(int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                 for(int last = 0; last < k; last++) {
                     if(last == j) continue;
                     min = Math.min(min, a[i - 1][last]);
                 }
                 a[i][j] += min;
            }
        }
                
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            res = Math.min(res, a[a.length - 1][i]);
        }
        return res;
    }
}

/*
[[3,20,7,7,16,8,7,12,11,19,1],
[10,14,3,3,9,13,4,12,14,13,1],
[10,1,14,11,1,16,2,7,16,7,19],
[13,20,17,15,3,13,8,10,7,8,9],
[4,14,18,15,11,9,19,3,15,12,15],
[14,12,16,19,2,12,13,3,11,10,9],
[18,12,10,16,19,9,18,4,14,2,4]]
*/