class Solution {
    public int maxNumberOfApples(int[] a) {
        Arrays.sort(a);
        int sum = 5000, res = 0;
        for(int i : a) {
            if(sum >= i) {
                res++; sum -= i;
            }
        }
        return res;
    }
}