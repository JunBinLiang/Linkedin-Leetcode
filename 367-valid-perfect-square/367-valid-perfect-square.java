class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;
        long x = -1;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            if(mid * mid >= num) {
                x = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return x * x == num;
    }
}