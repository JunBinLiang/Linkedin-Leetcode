class Solution {
    public boolean isDecomposable(String s) {
        int x = 0;
        for(int i = 0; i < s.length(); i++) {
            int j = i, cnt = 0;
            while(j < s.length() && s.charAt(i) == s.charAt(j)) {
                cnt++;
                j++;
            }
            i = j - 1;
            if(cnt % 3 == 1) return false;
            if(cnt % 3 == 2) {
                x++;
            }
        }
        return x == 1;
    }
}