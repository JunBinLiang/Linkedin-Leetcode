class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        long res = -1;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            long sqrt = mid * mid;
            if(sqrt <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int)(res);
    }
}
