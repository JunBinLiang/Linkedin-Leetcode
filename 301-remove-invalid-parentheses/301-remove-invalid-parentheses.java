class Solution {
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, new ArrayList<>());
        Set<String> set = new HashSet<>(res);
        return new ArrayList<>(set);
    }
    
    public void dfs(String s, int i, List<Character> list) {
        if(i >= s.length()) {
            if(check(list)) {
                StringBuilder str = new StringBuilder();
                for(char c : list) str.append(c);
                if(res.size() == 0) {
                    res.add(str.toString());
                } else {
                    if(str.length() > res.get(0).length()) {
                        res = new ArrayList<>();
                        res.add(str.toString());
                    } else if(str.length() == res.get(0).length()) {
                        res.add(str.toString());
                    }
                }
            }
            
            return;
        }
        
        char c = s.charAt(i);
        if(c == '(' || c == ')') {
            list.add(c);
            dfs(s, i + 1, list);
            list.remove(list.size() - 1);
            
            dfs(s, i + 1, list);
            
        } else {
            list.add(c);
            dfs(s, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean check(List<Character> list) {
        int cnt = 0;
        for(char c : list) {
            if(c == '(') cnt++;
            else if(c == ')') {
                if(cnt == 0) return false;
                cnt--;
            } else {
                
            }
        }
        return cnt == 0;
    }
}