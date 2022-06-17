class Solution {
    public int maximumUnits(int[][] a, int k) {
        Arrays.sort(a, (x, y) -> {
            return y[1] - x[1]; 
        });
        
        int res = 0;
        for(int i = 0; i < a.length; i++) {
            if(k >= a[i][0]) {
                res += a[i][0] * a[i][1];
                k -= a[i][0];
            } else {
                res += k * a[i][1];
                k = 0;
            }
        }
        return res;
    }
}