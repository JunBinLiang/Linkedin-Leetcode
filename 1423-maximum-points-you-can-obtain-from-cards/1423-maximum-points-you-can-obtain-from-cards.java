class Solution {
    public int maxScore(int[] a, int k) {
        int n = a.length;
        int sum = 0, total = 0;
        for(int i : a) {
            total += i;
        }
        
        int mn = total;
        k = n - k;
        
        if(k == 0) {
            return total;
        }
        
        for(int i = 0, j = 0; i < n; i++) {
            sum += a[i];
            if(i + 1 < k) continue;
            mn = Math.min(mn, sum);
            sum -= a[j++];
        }
        return total - mn;
    }
}