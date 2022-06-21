class Solution {
    public int findKthLargest(int[] a, int k) {
        k = a.length - k + 1;
        return dfs(a, 0, a.length - 1, k);
    }
    
    public int dfs(int a[], int l, int r, int k) {
        if(l == r) {
            return a[l];
        }
        
        int pivot = a[l];
        int j = l;
        int cnt = 0;
        for(int i = l; i <= r; i++) {
            if(a[i] < pivot) {
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                j++;
                cnt++;
            }    
        }
        
        int pIdx = -1;
        for(int i = l; i <= r; i++) {
            if(a[i] == pivot) pIdx = i;
        }
        int t = a[j];
        a[j] = pivot;
        a[pIdx] = t;
        
        
        if(cnt + 1 == k) {
            return pivot;
        }
        
        if(cnt >= k) {
            return dfs(a, l, j - 1, k);
        } else {
            return dfs(a, j + 1, r, k - cnt - 1);
        }
    }
}