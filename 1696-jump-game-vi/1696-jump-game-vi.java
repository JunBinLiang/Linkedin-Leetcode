class Solution {
    public int maxResult(int[] a, int k) {
        int n = a.length;
        int dp[] = new int[n];
        LinkedList<Integer> mono = new LinkedList<>(); 
        for(int i = 0; i < n; i++) {
            while(mono.size() > 0 && i - mono.getFirst() > k) {
                mono.removeFirst();
            }
            
            if(i == 0) {
                dp[i] = a[i];
            } else {
                dp[i] = a[i] + dp[mono.getFirst()];
            }
            
            while(mono.size() > 0 && dp[i] > dp[mono.getLast()]) {
                mono.removeLast();
            }
            mono.add(i);
        }
        
        return dp[n - 1];
    }
}


/*
class Solution {
    public int maxResult(int[] a, int k) {
        int n = a.length;
        int dp[] = new int[n];
        dp[0] = a[0];
        for(int i = 1; i < n; i++) {
            //dp[i] : dp[i - 1], dp[i - 2] ... dp[i - k]
            int mx = Integer.MIN_VALUE;
            for(int j = 1; j <= k; j++) {
                if(i - j >= 0) {
                    mx = Math.max(mx, dp[i - j]);
                }
            }
            dp[i] = mx + a[i];
        }
        return dp[n - 1];
    }
}

*/
