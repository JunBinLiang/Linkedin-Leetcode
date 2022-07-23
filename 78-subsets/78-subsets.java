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
        List<Integer> newlist = new ArrayList<>(list);
        newlist.add(a[i]);
        dfs(newlist, a, i + 1);
        
        //not add
        List<Integer> newlist1 = new ArrayList<>(list);
        dfs(newlist1, a, i + 1);
    }
}