class Solution {
    public long minimumHealth(int[] a, int armor) {
        long res = Long.MAX_VALUE;
        int n = a.length;
        long pre[] = new long[n];
        pre[0] = a[0];
        for(int i = 1; i < n; i++) {
            pre[i] = a[i] + pre[i - 1];
        }
             
        for(int i = 0; i < n; i++) {
            long sum = get(pre, 0, i - 1) + get(pre, i + 1, n - 1);
            sum += Math.max(0, a[i] - armor);
            res = Math.min(res, sum);
        }                            
        return res + 1;
    }
    
    public long get(long a[], int l, int r) {
        if(l > r) return 0;
        if(l == 0) return a[r];
        return a[r] - a[l - 1];
    }
}