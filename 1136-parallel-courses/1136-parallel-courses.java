class Solution {
    public int minimumSemesters(int n, int[][] edges) {
        List<Integer> graph[] = new ArrayList[n];
        Set<Integer> set = new HashSet<>();
        int in[] = new int[n];
        int dis[] = new int[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
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
                set.add(i);
                dis[i] = 1;
            }
        } 
        
        while(q.size() > 0) {
            int root = q.poll(); //take current courst
            for(int nxt : graph[root]) {
                if(set.contains(nxt)) {
                    return -1;
                }
                in[nxt]--;
                dis[nxt] = Math.max(dis[nxt], 1 + dis[root]);
                if(in[nxt] == 0) {
                    q.add(nxt);
                    set.add(nxt);
                }
            }
        }
        
        if(set.size() != n) {
            return -1;
        }
        
        int res = 0;
        for(int i : dis) res = Math.max(res, i);
        return res;
        
    }
}