class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int mn = 0;
        for(int i : nums) {
            sum += i;
            mn = Math.min(mn, sum);
        }
        return Math.abs(mn) + 1;
    }
}