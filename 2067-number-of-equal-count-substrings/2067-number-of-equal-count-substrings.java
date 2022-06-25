class Solution {
    public int equalCountSubstrings(String s, int count) {
        char a[] = s.toCharArray();
        int res = 0;
        for(int i = 0; i < 26; i++) {
            int k = count * (i + 1);
            if(k > a.length) break;
            
            int cnt[] = new int[26];
            for(int j = 0, l = 0; j < a.length; j++) {
                cnt[s.charAt(j) - 'a']++;
                if(j + 1 < k) continue;
                if(check(cnt, count, (i + 1))) {
                    res++;
                }
                cnt[s.charAt(l++) - 'a']--;
            }
        }
        return res;
    }
    
    public boolean check(int a[], int count, int y) {
        int x = 0;
        for(int i : a) {
            if(i == count) {
                x++;
            }
        }
        return x == y;
    }
}