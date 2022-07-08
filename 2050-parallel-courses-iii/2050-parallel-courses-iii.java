class Solution {
    public int minimumTime(int n, int[][] edges, int[] time) {
        List<Integer> graph[] = new ArrayList[n];
        int in[] = new int[n];
        int dis[] = new int[n];
        
        /*for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }*/
        Arrays.setAll(graph, e -> new ArrayList<>());
        
        for(int edge[] : edges) {
            //edge[0] -> edge[1]  u -> v
            int u = edge[0] - 1, v = edge[1] - 1;
            graph[u].add(v);
            in[v] += 1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(in[i] == 0) {
                //no pre, can take
                q.add(i);
                dis[i] = time[i];
            }
        } 
        
        while(q.size() > 0) {
            int root = q.poll();
            for(int nxt : graph[root]) {
                in[nxt]--;
                dis[nxt] = Math.max(dis[nxt], dis[root] + time[nxt]);
                if(in[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }
        
        int res = 0;
        for(int i : dis) res = Math.max(res, i);
        return res;
    }
}