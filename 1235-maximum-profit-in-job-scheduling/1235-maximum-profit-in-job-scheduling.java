class Solution {
    public int jobScheduling(int[] a, int[] b, int[] profit) {
        int n = a.length;
        int A[][] = new int[n][3];
        for(int i = 0; i < n; i++) {
            A[i][0] = a[i];
            A[i][1] = b[i];
            A[i][2] = profit[i];
        }
        Arrays.sort(A, (x, y) -> {
            return x[0] - y[0];
        });
        
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            return x[0] - y[0];
        });
        
        int mx = 0;
        
        for(int i = 0; i < n; i++) {
            while(pq.size() > 0 && pq.peek()[0] <= A[i][0]) {
                int pair[] = pq.poll();
                mx = Math.max(mx, pair[1]);
            }
            
            res = Math.max(res, A[i][2] + mx);
            pq.add(new int[]{A[i][1], A[i][2] + mx});
        }
        
        return res;
    }
}