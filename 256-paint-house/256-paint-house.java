class Solution {
    int last[][] = new int[][]{{1, 2}, {0, 2}, {0 ,1}};
    public int minCost(int[][] a) {
        int n = a.length;
        for(int i = 1; i < a.length; i++) {
            for(int j = 0; j < 3; j++) { //pain j 
                int min = Integer.MAX_VALUE;
                for(int k : last[j]) {
                    min = Math.min(min, a[i - 1][k]);
                }
                a[i][j] += min;
            }
        }
        
        return Math.min(a[n - 1][0], Math.min(a[n - 1][1], a[n - 1][2]));
    }
}