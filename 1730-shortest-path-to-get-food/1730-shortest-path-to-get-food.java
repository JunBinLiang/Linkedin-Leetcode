class Solution {
    int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int getFood(char[][] a) {
        int n = a.length, m = a[0].length;
        int dis[][] = new int[n][m];
        for(int di[] : dis) Arrays.fill(di, 1000000000);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == '*') {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    dis[i][j] = 0;
                    while(q.size() > 0) {
                        int pair[] = q.poll();
                        for(int d[] : dir) {
                            int r = d[0] + pair[0], c = d[1] + pair[1];
                            if(r < 0 || r >= n || c < 0 || c >= m || a[r][c] == 'X') continue;
                            if(dis[pair[0]][pair[1]] + 1 < dis[r][c]) {
                                dis[r][c] = dis[pair[0]][pair[1]] + 1;
                                q.add(new int[]{r, c});
                                if(a[r][c] == '#') {
                                    return dis[r][c];
                                }
                            }   
                        }
                    }
                }
            }
        }
        return -1;
    }
}