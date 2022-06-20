class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c - 'a' >= 0 && c - 'a' < 26) str.append(c);
            if(c - 'A' >= 0 && c - 'A' < 26) {
                c = (char)(c - 'A' + 'a');
                str.append(c);
            }
            if(c - '0' >= 0 && c - '0' < 10) str.append(c);
        }
        return is(str.toString());
    }
    
    public boolean is(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}