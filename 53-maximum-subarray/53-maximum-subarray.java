class Solution {
    public int maxSubArray(int[] a) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
            res = Math.max(res, sum);
            if(sum < 0) sum = 0;
        }
        return res;
    }
}