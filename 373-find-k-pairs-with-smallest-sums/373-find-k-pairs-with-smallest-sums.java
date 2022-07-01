class Solution {
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            return (a[x[0]] + b[x[1]]) - (a[y[0]] + b[y[1]]);
        });
        for(int i = 0; i < n; i++) {
            int pair[] = new int[]{i, 0};
            pq.add(pair);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        while(pq.size() > 0 && k > 0) {
            k--;
            int pair[] = pq.poll();
            List<Integer> l1 = new ArrayList<>();
            l1.add(a[pair[0]]);
            l1.add(b[pair[1]]);
            res.add(l1);
            pair[1]++;
            if(pair[1] < m) {
                pq.add(pair);
            }
        }
        return res;
        
    }
}

//[1,7,11]
//[2,4,6]

//[1 2]     [7 2] [11 2]  [1 4]


/*
//n * log(n) ^ 2
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;
        int l = a[0] + b[0], r = a[n - 1] + b[m - 1];
        int res = -1;
        
        //log(max)
        while(l <= r) {
            int mid = l + (r - l) / 2;
            //how many pairs <= mid
            int cnt = cal(a, b, mid);
            if(cnt >= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        if(res == -1) res = a[n - 1] + b[m - 1];
        
        //O(k)
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                List<Integer> l1 = new ArrayList<>();
                l1.add(a[i]); l1.add(b[j]);
                list.add(l1);
                if(a[i] + b[j] > res) break;
            }
        }
        Collections.sort(list, (l1, l2) -> {
            return (l1.get(0) + l1.get(1)) - (l2.get(0) + l2.get(1));  
        });
        for(int i = 0; i < Math.min(k, list.size()); i++) {
            ans.add(list.get(i));
        }
        return ans;
        
    }
    //how many pairs sum <= mid
    //log(n log(m))
    public int cal(int a[], int b[], int target) {
        int sum = 0;
        int n = a.length, m = b.length;
        for(int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            int res = -1;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(a[i] + b[mid] <= target) {
                    res = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            sum += (res + 1);
        }
        return sum;
    }
}


*/