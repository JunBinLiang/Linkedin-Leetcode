class Solution {
    Map<String, List<Integer>> f = new HashMap<>();
    public List<Integer> diffWaysToCompute(String s) {
        return dfs(s, 0, s.length() - 1);
    }
    
    public List<Integer> dfs(String s, int l, int r) {
        List<Integer> res = new ArrayList<>();
        String state = l + "," + r;
        if(f.containsKey(state)) return f.get(state);
        
        for(int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = dfs(s, l, i - 1);
                List<Integer> right = dfs(s, i + 1, r);
                for(int x : left) {
                    for(int y : right) {
                        if(c == '+')res.add(x + y);
                        if(c == '*')res.add(x * y);
                        if(c == '-')res.add(x - y);
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(Integer.parseInt(s.substring(l, r + 1)));
        }
        f.put(state, res);
        return res;
    }
}