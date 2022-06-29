class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int pos[] = new int[26];
        for(int i = 0; i < order.length(); i++) {
            pos[order.charAt(i) - 'a'] = i;
        }
        
        for(int i = 1; i < words.length; i++) {
            String s = words[i];
            String t = words[i - 1];
            boolean check = false;
            for(int j = 0; j < Math.min(s.length(), t.length()); j++) {
                int p1 = pos[s.charAt(j) - 'a'];
                int p2 = pos[t.charAt(j) - 'a'];
                if(p1 < p2) {
                    return false;
                } 
                if(p1 > p2) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                if(s.length() <  t.length()) {
                    return false;
                }
            }
        }
        
        return true;
    }
}