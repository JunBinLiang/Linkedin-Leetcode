class Solution {
    public boolean isNumber(String s) {
        int eIdx = s.length();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if(!isInt(s.substring(i + 1))) {
                    return false;
                }
                eIdx = i;
            }
        }
        
        return isDec(s.substring(0, eIdx)) || isInt(s.substring(0, eIdx));
    }
    
    
    
    public boolean isDec(String s) {
        if(s.length() == 0) {
            return false;
        }
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        int dot = 0, idx = -1;
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.') {
                dot++;
                idx = i;
            }
            char c = s.charAt(i);
            if(c - '0' >= 0 && c - '0' < 10) {
                cnt++;
            }
            
        }
        if(dot > 1) {
            return false;
        }
        
        return dot + cnt == s.length() && cnt > 0;
        
    }
    
    public boolean isInt(String s) {
        if(s.length() == 0) {
            return false;
        }
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c - '0' >= 0 && c - '0' < 10) {
                cnt++;
            }
        }
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            return cnt + 1 == s.length() && cnt > 0;
        } else {
            return cnt == s.length() && cnt > 0;
        }
    }
}