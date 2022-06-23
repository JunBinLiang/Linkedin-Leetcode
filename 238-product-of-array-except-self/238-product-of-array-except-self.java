class Solution {
    public int[] productExceptSelf(int[] a) {
        int n = a.length;
        int l[] = new int[n];
        int r[] = new int[n];
        int res[] = new int[n];
        l[0] = a[0];
        for(int i = 1; i < n; i++) {
            l[i] = l[i - 1] * a[i];
        }
        r[n - 1] = a[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * a[i];
        }
        
        
        for(int i = 0; i < n; i++) {
            int left = 1;
            int right = 1;
            if(i - 1 >= 0) left = l[i - 1];
            if(i + 1 < n) right = r[i + 1];
            res[i] = left * right;
        }
        return res;
    }
}