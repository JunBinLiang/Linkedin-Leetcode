class Solution {
    public int candy(int[] a) {
        int n = a.length;
        List<Integer> graph[] = new ArrayList[n];
        int in[] = new int[n];
        int dis[] = new int[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            if(i - 1 >= 0 && a[i - 1] > a[i]) {
                graph[i].add(i - 1);
                //graph[i - 1].add(i);
                in[i - 1]++;
            }
            if(i + 1 < n && a[i + 1] > a[i]) {
                graph[i].add(i + 1);
                in[i + 1]++;
            }
        }
       
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(in[i] == 0) {
                q.add(i);
                dis[i] = 1;
            }
        }
        
        while(q.size() > 0) {
            int root = q.poll();
            for(int nxt : graph[root]) {
                in[nxt]--;
                if(in[nxt] == 0) {
                    q.add(nxt);
                    dis[nxt] = Math.max(dis[nxt], 1 + dis[root]);
                }
            }
        }
        int res = 0;
        for(int i : dis) res += i;
        return res;
    }
}