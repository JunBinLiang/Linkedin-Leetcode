class Solution {
    public int search(int[] a, int target) {
        int l = 1, r = a.length - 1;
        int res = 0;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(a[mid] > a[0]) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int x = find(a, 0, res, target);
        int y = find(a, res + 1, a.length - 1, target);
        if(x != -1) return x;
        if(y != -1) return y;
        return -1;
    }
    
    public int find(int a[], int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(a[mid] == target) {
                return mid;
            }
            if(a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}