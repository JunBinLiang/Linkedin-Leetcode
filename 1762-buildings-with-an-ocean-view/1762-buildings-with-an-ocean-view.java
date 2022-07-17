class Solution {
    public int[] findBuildings(int[] a) {
        Stack<Integer> sta = new Stack<>();
        for(int i = 0; i < a.length; i++) {
            while(sta.size() > 0 && a[i] >= a[sta.peek()]) {
                sta.pop();
            }
            sta.push(i);
        }
        
        int res[] = new int[sta.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = sta.pop();
        }
        Arrays.sort(res);
        return res;
    }
}