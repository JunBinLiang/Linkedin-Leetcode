class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>(), new HashSet<>());
        return res;
    }
    
    public void dfs(int nums[], List<Integer> list, Set<Integer> set) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        
        for(int x : nums) {
            if(set.contains(x)) continue;
            list.add(x);
            set.add(x);
            dfs(nums, list, set);
            list.remove(list.size() - 1);
            set.remove(x);   
        }
    }
}