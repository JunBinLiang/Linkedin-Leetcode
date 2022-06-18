//start : 7:56
//end : 8:01

class Solution {
    public int triangleNumber(int[] a) {
        Arrays.sort(a);
        int res = 0;
        for(int i = 0; i < a.length; i++) {
            int l = 0, r = i - 1;
            while(l < r) {
                if(a[l] + a[r] > a[i]) {
                    res += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }
        
        return res;
    }
}