class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(new ArrayList<>(), s, 0);
        return res;
    }
    
    public void dfs(List<String> list, String s, int i) {
        if(i >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if(isp(sub)) {
                list.add(sub);
                dfs(list, s, j + 1);
                list.remove(list.size() - 1);
            }
        }
        
        
    }
    
    public boolean isp(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}