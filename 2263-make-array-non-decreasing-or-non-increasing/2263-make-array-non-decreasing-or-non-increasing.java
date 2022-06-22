//start : 2 : 30
//end : 

class Solution {
    public int convertArray(int[] a) {
        int v1 = cal(a);
        reverse(a);
        int v2 = cal(a);
        return Math.min(v1, v2);
    }
    
    public int cal(int a[]) {
        int n = a.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            return y - x;
        });
        int res = 0;
        for(int i : a) {
            if(pq.size() == 0) {
                pq.add(i);
            } else {
                if(pq.peek() > i) {
                    res += (pq.poll() - i);
                    pq.add(i);
                }
                pq.add(i);
            }
        }
        return res;
        
    }
    
    public void reverse(int a[]) {
        int l = 0, r = a.length - 1;
        while(l < r) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++; r--;
        }
    }
}

//2 4 5 5 1 8        