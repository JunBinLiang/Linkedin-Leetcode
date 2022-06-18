class Solution {
    public long singleDivisorTriplet(int[] a) {
        long res = 0;
        int nums[] = new int[101];
        for(int i : a) {
            nums[i]++;
        }
        
        int per[] = new int[4];
        per[1] = 1;
        per[2] = 2;
        per[3] = 6;
        
        List<int[]> list = new ArrayList<>();
        for(int  i = 1; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            for(int j = 1; j < nums.length; j++) {
                if(nums[j] == 0) continue;
                for(int k = 1; k < nums.length; k++) {
                    if(nums[k] == 0) continue;
                    int sum = i + j + k;
                    int cnt = 0;
                    if(sum % i == 0) {
                        cnt++;
                    }
                    if(sum % j == 0) {
                        cnt++;
                    }
                    if(sum % k == 0) {
                        cnt++;
                    }
                    
                    if(cnt == 1) {
                        list.add(new int[]{i, j, k});
                    }
                }
            }
        }
        
        for(int p[] : list) {
            Arrays.sort(p);
            long x = 1;
            boolean flag = true;
            for(int i = 0; i < p.length; i++) {
                int j = i;
                int cnt = 0;
                while(j < p.length && p[j] == p[i]) {
                    j++;
                    cnt++;
                }
                if(nums[p[i]] >= cnt) {
                    x *= (C(nums[p[i]], cnt) * per[cnt]);
                } else {
                    flag = false;
                }
                
                i = j - 1;
            }
            if(flag) {
                res += x;
            }
        }
        
        
        return res;
    }
    
    public long C(int n, int r) {
        long x = 1, y = 1;
        for(int i = 0; i < r; i++) {
            x *= (n - i);
            y *= (i + 1);
        }
        return x / y;
    }
}