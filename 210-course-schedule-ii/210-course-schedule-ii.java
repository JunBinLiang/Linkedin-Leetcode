class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<Integer> graph[] = new ArrayList[n];
        Set<Integer> set = new HashSet<>();
        int in[] = new int[n];
        int dis[] = new int[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int edge[] : edges) {
            //edge[1] -> edge[0]  u -> v
            int u = edge[1], v = edge[0];
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
                    return new int[]{};
                }
                in[nxt]--;
                if(in[nxt] == 0) {
                    q.add(nxt);
                    dis[nxt] = Math.max(dis[nxt], 1 + dis[root]);
                    set.add(nxt);
                }
            }
        }
        
        if(set.size() != n) {
            return new int[]{};
        }
        
        
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            //dis[i], courst number
            list.add(new int[]{dis[i], i});
        }
        Collections.sort(list, (a, b) -> {
            return a[0] - b[0];
        });
        
        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = list.get(i)[1];
        }
        return res;
    }
}