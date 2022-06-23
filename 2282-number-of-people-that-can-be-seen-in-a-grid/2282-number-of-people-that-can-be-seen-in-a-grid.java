class Solution {
    public int[][] seePeople(int[][] a) {
        int n = a.length, m = a[0].length;
        int res[][] = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            Stack<Integer> sta = new Stack<>();
            for(int j = 0; j < m; j++) {
                boolean check = false;
                if(sta.size() == 0) {
                    sta.push(j);
                } else {
                    while(sta.size() > 0 && a[i][j] >= a[i][sta.peek()]) {
                        int idx = sta.pop();
                        if(a[i][j] == a[i][idx])check = true;
                        res[i][idx]++;
                    }
                    if(sta.size() > 0 && !check) res[i][sta.peek()]++;
                    sta.push(j);
                }
            }
        }
        
        for(int j = 0; j < m; j++) {
            Stack<Integer> sta = new Stack<>();
            for(int i = 0; i < n; i++) {
                boolean check = false;
                if(sta.size() == 0) {
                    sta.push(i);
                } else {
                    while(sta.size() > 0 && a[i][j] >= a[sta.peek()][j]) {
                        int idx = sta.pop();
                        if(a[i][j] == a[idx][j]) check = true;
                        res[idx][j]++;
                    }
                    if(sta.size() > 0 && !check) res[sta.peek()][j]++;
                    sta.push(i);
                }
            }
        }
        
        return res;
    }
}