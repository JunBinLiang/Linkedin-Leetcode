class Solution {
    public int widestPairOfIndices(int[] a, int[] b) {
        int n = a.length;
        int res = 0;
        int sum1 = 0, sum2 = 0;
        Map<Integer, Integer> f = new HashMap<>();
        for(int i = 0; i < n; i++) {
            sum1 += a[i];
            sum2 += b[i];
            if(sum1 - sum2 == 0) {
                res = i + 1;
            }
            
            if(f.containsKey(sum1 - sum2)) {
                res = Math.max(res, i - f.get(sum1 - sum2));
            } else {
                f.put(sum1 - sum2, i);
            }
        }
        
        return res;
    }
}