class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] a) {
        dfs(new ArrayList<>(), a, 0);
        return res;
    }
    
    public void dfs(List<Integer> list, int a[], int i) {
        if(i >= a.length) {
            res.add(new ArrayList<>(list));
            return;
        }
         
        //add
        list.add(a[i]);
        dfs(list, a, i + 1);
        list.remove(list.size() - 1);
        
        //not add
        dfs(list, a, i + 1);
    }
}