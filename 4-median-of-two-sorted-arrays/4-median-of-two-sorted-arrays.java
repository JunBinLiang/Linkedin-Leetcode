class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }
        int n = a.length, m = b.length;
        if((n + m) % 2 == 1) {
            return findk(a, b, (n + m) / 2 + 1);
        } else {
            return (findk(a, b, (n + m) / 2) + findk(a, b, (n + m) / 2 + 1) + 0.0 ) / 2;
        }   
    }
    
    public int get(int a[], int i) {
        if(i >= a.length) {
            return 1000000000;
        }
        return a[i];
    }
    
    public int findk(int a[], int b[], int k) {
        if(a.length == 0) {
            return b[k - 1];
        }
        
        if(a.length == k && a[k - 1] <= b[0]) {
            return a[k - 1];
        } 
        
        int n = a.length, m = b.length;
        int l = 1, r = Math.min(n, k);
        int pos = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int idx1 = mid - 1;
            int idx2 = (k - mid) - 1;
            int min = Math.min(get(a, idx1 + 1), get(b, idx2 + 1));
            if(min >= a[idx1] && min >= b[idx2]) {
                return Math.max(a[idx1], b[idx2]);
            } else if(min < a[idx1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return b[k - 1];
    }
}