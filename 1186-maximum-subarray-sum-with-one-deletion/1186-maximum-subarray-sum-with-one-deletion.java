class Solution {
    public int maximumSum(int[] a) {
        int n = a.length;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
            res = Math.max(res, sum);
            if(sum < 0) sum = 0;
        }
        //no delete
        
        
        int l[] = new int[n];
        int r[] = new int[n];
        sum = 0;
        int min = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
            l[i] = sum - min;
            min = Math.min(min, sum);
        }
        
        sum = 0;
        min = 0;
        for(int i = n - 1; i >= 0; i--) {
            sum += a[i];
            r[i] = sum - min;
            min = Math.min(min, sum);
        }
        
        
        for(int i = 1; i < n - 1; i++) {
            //delete at i
            res = Math.max(res, l[i - 1] + r[i + 1]);
        }
        
        
        return res;
    }
}

