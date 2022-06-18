class Solution {
    List<Integer> graph[];
    int dis[][];
    int fa[];
    int lca = -1;
    public int[] closestNode(int n, int[][] edges, int[][] q) {
        int res[] = new int[q.length];
        dis = new int[n][n];
        fa = new int[n];
        graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for(int edge[] : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        
        for(int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean seen[] = new boolean[n];
            seen[i] = true;
            queue.add(i);
            while(queue.size() > 0) {
                int root = queue.poll();
                for(int nxt : graph[root]) {
                    if(!seen[nxt]) {
                        seen[nxt] = true;
                        dis[i][nxt] = dis[i][root] + 1;
                        queue.add(nxt);
                    }
                }
            }
        }
        
        dfs(-1, 0);
        
        
        for(int i = 0; i < q.length; i++) {
            int u = q[i][0], v = q[i][1], node = q[i][2];
            if(u == v) {
                res[i] = u;
                continue;
            }
            
            int mn = 1000000000;
            int close = -1;
            lca = -1;
            LCA(-1, 0, u, v);
            if(dis[u][node] < mn) {
                mn = dis[u][node];
                close = u;
            }
            if(dis[v][node] < mn) {
                mn = dis[v][node];
                close = v;
            }
            if(dis[lca][node] < mn) {
                mn = dis[lca][node];
                close = lca;
            }
            
            while(u != lca) {
                u = fa[u];
                if(u == -1) break;
                if(dis[u][node] < mn) {
                    mn = dis[u][node];
                    close = u;
                }
            }
            
            
            while(v != lca) {
                v = fa[v];
                if(v == -1) break;
                if(dis[v][node] < mn) {
                    mn = dis[v][node];
                    close = v;
                }
            }
            res[i] = close;
        }
        
        return res;
    }
    
    public void dfs(int pa, int root) {
        fa[root] = pa;
        for(int nxt : graph[root]) {
            if(nxt == pa) continue;
            dfs(root, nxt);
        }
    }
    
    public int LCA(int pa, int root, int u, int v) {
        int cnt = 0;
        if(root == u || root == v) {
            cnt++;
        }
        for(int nxt : graph[root]) {
            if(pa == nxt) continue;
            cnt += LCA(root, nxt, u, v);
        }
        if(cnt == 2) {
            if(lca == -1) lca = root;
        }
        return cnt;
    }
    
}