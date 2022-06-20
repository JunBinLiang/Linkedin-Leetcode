class Solution {
    public int[][] insert(int[][] a, int[] b) {
        if(a.length == 0) {
            int res[][] = new int[1][2];
            res[0] = b;
            return res;
        };
        
        int n = a.length;
        int s = b[0], e = b[1];
        
        boolean first = false;
        List<int[]> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(s <= a[i][1] && e >= a[i][0]) {
                first = true;
                int j = i + 1;
                int newEnd = Math.max(e, a[i][1]);
                while(j < n && a[j][0] <= e) {
                    newEnd = Math.max(newEnd, a[j][1]);
                    j++;
                }
                res.add(new int[]{Math.min(a[i][0], s), newEnd});
                i = j - 1;
                
            } else {
                res.add(a[i]);
            }    
        }
        
        
        if(!first) {
            res.clear();
            if(b[1] < a[0][0]) { //front
                res.add(b);
            }
            for(int i = 0; i < n; i++) {
                res.add(a[i]);
                if(i + 1 < n && b[0] > a[i][1] && b[1] < a[i + 1][0]) {
                    res.add(b);
                }
            }
            if(b[0] > a[n - 1][1]) {
                res.add(b);
            }
            
            return change(res);
        }
        
        
        return change(res);
        
    }
    
    public int[][] change(List<int[]> list) {
        int res[][] = new int[list.size()][2];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
