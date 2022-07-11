class Solution {
    public int minCostII(int[][] a) {
        int k = a[0].length;
        int l[] = new int[k];
        int r[] = new int[k];
        
        for(int j = 0; j < k; j++) {
            l[j] = a[0][j];
            if(j - 1 >= 0) l[j] = Math.min(l[j], l[j - 1]);
        }
        
        for(int j = k - 1; j >= 0; j--) {
            r[j] = a[0][j];
            if(j + 1 < k) r[j] = Math.min(r[j], r[j + 1]);
        }
        
        
        for(int i = 1; i < a.length; i++) {
            for(int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                if(j - 1 >= 0) min = Math.min(min, l[j - 1]);
                if(j + 1 < k) min = Math.min(min, r[j + 1]);
                a[i][j] += min; 
            }
            
            for(int j = 0; j < k; j++) {
                l[j] = a[i][j];
                if(j - 1 >= 0) l[j] = Math.min(l[j], l[j - 1]);
            }

            for(int j = k - 1; j >= 0; j--) {
                r[j] = a[i][j];
                if(j + 1 < k) r[j] = Math.min(r[j], r[j + 1]);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            res = Math.min(res, a[a.length - 1][i]);
        }
        return res;
    }
}

/*
class Solution {
    public int minCostII(int[][] a) {
        int k = a[0].length;
        for(int i = 1; i < a.length; i++) {
            for(int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                 for(int last = 0; last < k; last++) {
                     if(last == j) continue;
                     min = Math.min(min, a[i - 1][last]);
                 }
                 a[i][j] += min;
            }
        }
                
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            res = Math.min(res, a[a.length - 1][i]);
        }
        return res;
    }
}

*/