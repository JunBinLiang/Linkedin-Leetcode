class Solution {
    public int shortestDistance(String[] a, String s, String t) {
        int res = Integer.MAX_VALUE;
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