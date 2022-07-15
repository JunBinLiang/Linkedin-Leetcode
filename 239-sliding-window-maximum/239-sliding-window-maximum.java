class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        LinkedList<Integer> mono = new LinkedList<>(); 
        int res[] = new int[a.length - k + 1];
        for(int i = 0; i < a.length; i++) {
            //delete -> add
            while(mono.size() > 0 && i - mono.getFirst() >= k) {
                mono.removeFirst();
            }
            
            while(mono.size() > 0 && a[i] > a[mono.getLast()]) {
                mono.removeLast();
            }
            mono.add(i);
            
            if(i + 1 >= k) {
                res[i - k + 1] = a[mono.getFirst()];
            }
            
        }
        
        return res;
    }
}
