class Solution {
    public int minSumOfLengths(int[] a, int target) {
        //dp + prefix sum
        int n = a.length;
        int sum = 0;
        int res = 1000000000;
        Map<Integer, Integer> f = new HashMap<>();
        f.put(0, -1);
        int l[] = new int[a.length];
        int r[] = new int[a.length];
        int lmin = 1000000000;
        int rmin = 1000000000;
        
        for(int i = 0; i < n; i++) {
            sum += a[i];
            if(f.containsKey(sum - target)) {
                int len = i - f.get(sum - target);
                lmin = Math.min(lmin, len);
            } 
            f.put(sum, i);
            l[i] = lmin;
        }
        
        
        sum = 0;
        f = new HashMap<>();
        f.put(0, n);
        for(int i = n - 1; i >= 0; i--) {
            sum += a[i];
            if(f.containsKey(sum - target)) {
                int len = f.get(sum - target) - i;
                rmin = Math.min(rmin, len);
            } 
            r[i] = rmin;
            f.put(sum, i);
        }
        
        for(int i = 0; i < n - 1; i++) {
            res = Math.min(res, l[i] + r[i + 1]);
        } 
        
        
        if(res > a.length) {
            return -1;
        }
        return res;
    }
}