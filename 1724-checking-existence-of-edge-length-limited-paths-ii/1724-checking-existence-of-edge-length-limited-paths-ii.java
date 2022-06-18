class DistanceLimitedPathsExist {
    int edges[][];
    int nums[];
    List<int[]> graph[];
    boolean seen[];
    int f[][];
    int maxs[][];
    int levels[];
    public DistanceLimitedPathsExist(int n, int[][] edges) {
        Arrays.sort(edges, (x, y) -> {
            return x[2] - y[2];
        });
        
        nums = new int[n];
        graph = new ArrayList[n];
        seen = new boolean[n];
        levels = new int[n];
        
        for(int i = 0; i < n; i++) {
            nums[i] = i;
            graph[i] = new ArrayList<>();
        }
        
        for(int edge[] : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int r1 = find(nums, u), r2 = find(nums, v);
            if(r1 != r2) {
                nums[r1] = r2;
                graph[u].add(new int[]{v, w});
                graph[v].add(new int[]{u, w});
            }
        }
        
        f = new int[n][16];
        maxs = new int[n][16];
        for(int p[]: maxs) {
            Arrays.fill(p, Integer.MIN_VALUE);
        }
        
        for(int p[]: f) {
            Arrays.fill(p, -1);
        }
        
        for(int i = 0; i < n; i++) {
            if(!seen[i]) {
                seen[i] = true;
                dfs(i);
            }
        }
        
        for(int i = 1; i < f[0].length;i++){//construc sparse table
            for(int j = 0;j < n; j++){
                int parent = f[j][i-1];
                if(parent != -1 && f[parent][i - 1] != -1){
                    f[j][i] = f[parent][i - 1];
                    maxs[j][i] = Math.max(maxs[j][i - 1], maxs[parent][i - 1]);
                }
            }
        }
    }
    
    public void dfs(int root) {
        for(int pair[] : graph[root]) {
            int nxt = pair[0], w = pair[1];
            if(!seen[nxt]) {
                seen[nxt] = true;
                f[nxt][0] = root;
                maxs[nxt][0] = w;
                levels[nxt] = levels[root] + 1;
                dfs(nxt);
            }
        }
    }
    
    public boolean query(int p, int q, int limit) {
        int r1 = find(nums, p);
        int r2 = find(nums, q);
        if(r1 != r2) {
            return false;
        }
        
        //path in minimum spanning tree from p -> q <= limit
        int lca = LCA(p, q);
        
        int mx = 0;
        int d1 = levels[p] - levels[lca];
        int d2 = levels[q] - levels[lca];
        
        for(int i = 0; i < 16; i++) {
            if((d1 & (1 << i)) > 0) {
                mx = Math.max(mx, maxs[p][i]);
                p = f[p][i];
            }
        }

        for(int i = 0; i < 16; i++) {
            if((d2 & (1 << i)) > 0) {
                mx = Math.max(mx, maxs[q][i]);
                q = f[q][i];
            }
        }
          
        return mx < limit;
    }
    
    public int find(int nums[], int x){
      if(nums[x] == x) return x;
      int root = find(nums, nums[x]);
      nums[x] = root;
      return root;
    }
    
     public int LCA(int x,int y){
        if(levels[x] < levels[y]){
            return LCA(y,x);
        }
        for(int i = 15; i>=0; i--) {
            if(f[x][i] != -1 && levels[f[x][i]] >= levels[y]) {
                x = f[x][i];
            }
        }
        if(x == y) return x;
        for(int i = 15; i>=0; i--)
        {
            if(f[x][i] != f[y][i]) 
            {                    

                x = f[x][i];
                y = f[y][i];
            }
        }
        return f[x][0];
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */