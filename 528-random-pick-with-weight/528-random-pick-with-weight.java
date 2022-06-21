class Solution {
    int a[];
    public Solution(int[] w) {
        this.a = w;
        for(int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int val = rand.nextInt(a[a.length - 1]) + 1;
        int l = 0, r = a.length - 1;
        int pos = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(val <= a[mid]) {
                pos = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
