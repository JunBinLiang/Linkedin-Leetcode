class Solution {
    public int numSubarrayProductLessThanK(int[] a, int k) {
        if(k == 0) return 0;
        int pro = 1;
        int res = 0;
        for(int i = 0, j = 0; i < a.length; i++) {
            pro *= a[i];
            while(j < a.length && pro >= k) {
                pro /= a[j++];
            }
            int size = i - j  + 1;
            res += Math.max(0, size);
        }
        return res;
    }
}