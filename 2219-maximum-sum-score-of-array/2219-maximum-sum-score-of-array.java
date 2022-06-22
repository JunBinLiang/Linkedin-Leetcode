class Solution {
    public long maximumSumScore(int[] a) {
        long res = Long.MIN_VALUE;
        long l = 0, r = 0;
        for(long i : a) r += i;
        for(int i = 0; i < a.length; i++) {
            l += a[i];
            res = Math.max(res, Math.max(l, r));
            r -= a[i];
        }
        return res;
    }
}