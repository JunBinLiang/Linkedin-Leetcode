class Solution {
    int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] a) {
        int n = a.length, m = a[0].length;
        int dis[] = new int[n * m];
        int in[] = new int[n * m];
        List<Integer> graph[] = new ArrayList[n * m];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int idx1 = i * m + j;
                for(int d[] : dir) {
                    int r = i + d[0], c = j + d[1];
                    if(r < 0 || r >= n || c < 0 || c >= m) continue;
                    if(a[r][c] > a[i][j]) {
                        int idx2 = r * m + c;
                        graph[idx1].add(idx2);
                        in[idx2]++;
                    }
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n * m; i++) {
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
        for(int i : dis) res = Math.max(res, i);
        return res;
    }
}