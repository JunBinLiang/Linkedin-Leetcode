class Solution {
    public int maxProduct(int[] a) {
        int res = Integer.MIN_VALUE;
        int pro = 1; int n = a.length;
        int neg = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, a[i]);
            pro *= a[i];
            if(pro > 0) {
                res = Math.max(res, pro);
            } else if  (pro < 0) {
                if(neg != Integer.MIN_VALUE) {
                    res = Math.max(res, pro / neg);
                }
                neg = Math.max(neg, pro);
            } else {
                pro = 1;
                neg = Integer.MIN_VALUE;
            }
        }
        return res;
    }
}