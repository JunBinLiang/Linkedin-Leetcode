class Solution {
    public int[] amountPainted(int[][] a) {
        int n = a.length;
        int res[] = new int[n];
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i = 0; i <= 50000 + 5; i++) {
            tree.add(i);
        }
        
        for(int i = 0; i < n; i++) {
            int l = a[i][0], r = a[i][1] - 1;
            int cnt = 0;
            while(true) {
                Integer ceil = tree.ceiling(l);
                if(ceil != null && ceil <= r) {
                    cnt++;
                    tree.remove(ceil);
                } else {
                    break;
                }
            }
            res[i] = cnt;
        }
        return res;
    }
}