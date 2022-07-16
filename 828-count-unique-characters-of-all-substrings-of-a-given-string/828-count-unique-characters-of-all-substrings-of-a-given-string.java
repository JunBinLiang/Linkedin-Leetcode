class Solution {
    public int uniqueLetterString(String s) {
        List<Integer> pos[] = new ArrayList[26];
        Arrays.setAll(pos, e -> new ArrayList<>());
        int res = 0;
        for(int i = 0; i < 26; i++) {
            pos[i].add(-1);
        }
        
        for(int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'A'].add(i);
        }
        
        for(int i = 0; i < 26; i++) {
            pos[i].add(s.length());
        }
        
        
        for(int i = 0; i < 26; i++) {
            for(int j = 1; j < pos[i].size() - 1; j++) {
                int l = pos[i].get(j) - pos[i].get(j - 1) - 1;
                int r = pos[i].get(j + 1) - pos[i].get(j) - 1;
                res += (l + r);
                res += (l * r);
                res++;
            }
        }
        
        
        return res;
    }
}


//  AAXXXAXX