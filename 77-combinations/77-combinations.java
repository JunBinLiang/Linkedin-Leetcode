class Solution {
    List<List<Integer>> res  = new ArrayList<>();
    int n, k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(new ArrayList<>());
        return res;
    }
    
    public void dfs(List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        
        int start = 0;
        if(list.size() > 0) {
            start = list.get(list.size() - 1);
        }
        
        for(int i = start + 1; i <= n; i++) {
            list.add(i);
            dfs(list);
            list.remove(list.size() - 1);
        }
        
    }
}