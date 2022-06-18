class Solution {
    public boolean isConsecutive(int[] nums) {
        int mn = 1000000000, mx = -1000000000;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.contains(i)) {
                return false;
            }
            set.add(i);
            mn = Math.min(mn, i);
            mx = Math.max(mx, i);
        }
        return set.size() == (mx - mn + 1);
    }
}