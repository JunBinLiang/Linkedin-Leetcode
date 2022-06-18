class Solution {
    public int kthSmallestSubarraySum(int[] a, int k) {
        int l = 0, r = 0;
        for(int i : a) r += i;
        int res = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = check(a, mid);
            if(cnt >= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
    
    public int check(int a[], int mid) {
        int sum = 0, res = 0;
        for(int i = 0, j = 0; i < a.length; i++) {
            sum += a[i];
            while(sum > mid) {
                sum -= a[j++];
            }
            res += (i - j + 1);
        }
        return res;
    }
}