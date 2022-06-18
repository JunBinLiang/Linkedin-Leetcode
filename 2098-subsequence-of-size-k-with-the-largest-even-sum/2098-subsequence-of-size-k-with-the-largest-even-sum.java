class Solution {
    public long largestEvenSum(int[] a, int k) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        long res = -1;
        for(int i : a) {
            if(i % 2 == 1) odd.add(i);
            else even.add(i);
        }
        Collections.sort(even);
        Collections.sort(odd);
        Collections.reverse(odd);
        Collections.reverse(even);
        
        long pre[] = new long[even.size()];
        if(pre.length > 0) {
            pre[0] = even.get(0);
            for(int i = 1; i < pre.length; i++) {
                pre[i] = pre[i - 1] + even.get(i);
            }
        }
        
        if(pre.length >= k) {
            res = Math.max(res, pre[k - 1]);
        }
        
        long sum = 0;
        for(int i = 0; i < odd.size(); i++) {
            sum += odd.get(i);
            if(i % 2 == 1) {
                int need = k - (i + 1);
                if(need == 0) {
                    res = Math.max(res, sum);
                }
                else if(need > 0) {
                    if(need <= pre.length) {
                        res = Math.max(res, sum + pre[need - 1]);
                    }
                }
            }
        }
        return res; 
    } 
}