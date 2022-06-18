//0 0 0 1       1 0 0 0

class Solution {
    public boolean canPlaceFlowers(int[] a, int k) {
        int res = 0;
        int last = -1;
        
        for(int i = 0; i < a.length; i++) {
            if(a[i] == 1) {
                if(last == -1) {
                    int cnt = i;
                    res += cnt / 2;
                    System.out.println(cnt);
                } else {
                    int cnt = i - last - 1;
                    res += (cnt - 1) / 2;
                }
                last = i;
            }
        }
        
        if(last == - 1) {
            res += (a.length  + 1) / 2;
        } else {
            int cnt = a.length - last - 1;
            res += (cnt) / 2;
        }

        
        
        return res >= k;
    }
}
