//Time : 
class Solution {
    public int maxKilledEnemies(char[][] a) {
        int res = 0;
        int n = a.length, m = a[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == '0') {
                    int sum = 0;
                    int l = j - 1, r = j + 1;
                    while(l >= 0 && a[i][l] != 'W') {
                        if(a[i][l] == 'E') sum++;
                        l--;
                    }
                    while(r < m && a[i][r] != 'W') {
                        if(a[i][r] == 'E') sum++;
                        r++;
                    }
                    
                    int u = i - 1, d = i + 1;
                    while(u >= 0 && a[u][j] != 'W') {
                        if(a[u][j] == 'E') sum++;
                        u--;
                    }
                    while(d < n && a[d][j] != 'W') {
                        if(a[d][j] == 'E') sum++;
                        d++;
                    }
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }
}