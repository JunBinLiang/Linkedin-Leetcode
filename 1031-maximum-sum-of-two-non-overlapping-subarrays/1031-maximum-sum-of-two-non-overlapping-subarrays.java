class Solution {
    public int maxSumTwoNoOverlap(int[] a, int k1, int k2) {
        return Math.max(cal(a, k1, k2), cal(a, k2, k1));
    }
    
    public int cal(int[] a, int k1, int k2) {
        int n = a.length;
        int res = 0;
        int l[] = new int[n];
        int r[] = new int[n];
        
        int sum = 0;
        int mx = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
            if(i + 1 < k1) continue;
            mx = Math.max(mx, sum);
            l[i] = mx;
            sum -= a[i - k1 + 1];
        }
        
        sum = 0;
        mx = 0;
        int size = 0;
        for(int i = n - 1; i >= 0; i--) {
            sum += a[i];
            size++;
            if(size < k2) continue;
            mx = Math.max(mx, sum);
            r[i] = mx;
            sum -= a[i + k2 - 1];
        }
        
        for(int i = 0; i < n - 1; i++) {
            res = Math.max(res, l[i] + r[i + 1]);
        } 
        return res;
    }
}