class Solution {
    List<Integer> graph[];
    int dis[], low[];
    int t = 1;
    public int[] distanceToCycle(int n, int[][] edges) {
        int res[] = new int[n];
        graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        dis = new int[n];
        low = new int[n];
        
        for(int edge[] : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        dfs(-1, 0);
        Map<Integer, List<Integer>> f = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!f.containsKey(low[i])) {
                f.put(low[i], new ArrayList<>());
            }
            f.get(low[i]).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean seen[] = new boolean[n];
        for(Integer key : f.keySet()) {
            List<Integer> list = f.get(key);
            if(list.size() > 1) {
                for(int j : list) {
                    seen[j] = true;
                    q.add(j);
                }
            }
        }
        
        int dis = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int root = q.poll();
                res[root] = dis;
                for(int nxt : graph[root]) {
                    if(!seen[nxt]) {
                        seen[nxt] = true;
                        q.add(nxt);
                    }
                }
            }
            dis++;
        }
        
        return res;
    }
    
    public void dfs(int pa, int root) {
        dis[root] = low[root] = t++;
        for(int nxt : graph[root]) {
            if(dis[nxt] == 0) {
                dfs(root, nxt);
                low[root] = Math.min(low[root], low[nxt]);
            } else {
                if(nxt != pa) {
                    low[root] = Math.min(low[root], low[nxt]);
                }
            }
        }
    }
}