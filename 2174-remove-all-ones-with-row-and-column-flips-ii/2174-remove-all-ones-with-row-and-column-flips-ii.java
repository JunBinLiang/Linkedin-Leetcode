//start : 6 : 45
//end :
class Solution {
    public int removeOnes(int[][] a) {
        int n = a.length, m = a[0].length;
        int res = n * m;
        for(int state = 0; state < (1 << (n * m)); state++) {
            int cnt = 0;
            boolean fillr[] = new boolean[n];
            boolean fillc[] = new boolean[m];
            for(int j = 0; j < n * m; j++) {
                if((state & (1 << j)) > 0) {
                    int r = j / m;
                    int c = j % m;
                    if(a[r][c] == 1) {
                        cnt++;
                        fillr[r] = fillc[c] = true;
                    }
                }
            }
            
            if(check(a, fillr, fillc)) {
                res = Math.min(res, cnt);
            }
        }
        return res;
    }
    
    public boolean check(int a[][], boolean r[], boolean c[]) {
        int n = a.length, m = a[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 1) {
                    if(!r[i] && !c[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}