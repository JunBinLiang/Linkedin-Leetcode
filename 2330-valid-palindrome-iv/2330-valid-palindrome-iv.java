class Solution {
    public boolean makePalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        int cnt = 2;
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                cnt--;
            }
            l++; r--;
        }
        return cnt >= 0;
    }
}