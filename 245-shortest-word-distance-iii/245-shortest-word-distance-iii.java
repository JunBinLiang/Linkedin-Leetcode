//start : 11 : 51
//ens : 11 : 54

class Solution {
    public int shortestWordDistance(String[] a, String s, String t) {
        int res = Integer.MAX_VALUE;
        if(s.equals(t)) {
            int last = -1;
            for(int i = 0; i < a.length; i++) {
                if(a[i].equals(s)) {
                    if(last != -1) {
                        res = Math.min(res, i - last);
                    }
                    last = i;
                }
            }
            return res;
        }
        
        int p1 = -1, p2 = -1;
        for(int i = 0; i < a.length; i++) {
            if(a[i].equals(s)) {
                if(p2 != -1) res = Math.min(res, i - p2);
                p1 = i;
            }
            if(a[i].equals(t)) {
                if(p1 != -1) res = Math.min(res, i - p1);
                p2 = i;
            }
        }
        return res;
    }
}