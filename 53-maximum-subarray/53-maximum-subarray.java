//start : 7 : 10
//end : 7 : 12
class Solution {
    public int maxSubArray(int[] a) {
        int res = -1000000000;
        int sum = 0, mn = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
            res = Math.max(res, sum - mn);
            mn = Math.min(mn, sum);
        }
        return res;
    }
}