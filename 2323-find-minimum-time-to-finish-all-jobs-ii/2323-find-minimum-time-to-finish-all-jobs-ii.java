class Solution {
    public int minimumTime(int[] a, int[] b) {
        int n = a.length;
        Arrays.sort(a); Arrays.sort(b);
        int res = 0;
        for(int i = 0; i < n; i++) {
            int x = a[i] / b[i];
            if(a[i] % b[i] != 0) x++;
            res = Math.max(res, x);
        }
        return res;
    }
}