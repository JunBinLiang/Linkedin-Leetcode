class Solution {
    public int bulbSwitch(int n) {
        int res = 0;
        for(int i = 1; i * i <= n; i++) {
            res++;
        }
        return res;
        
    }
    
    public int cal(int n) {
        int cnt = 0;
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                cnt++;
                if(n / i != i) cnt++;
            }
        }
        return cnt;
    }
}

//20
//1 2 4 5 10 20

//1 2 3 4 5 6 ...
//  2   4   6  8 ...
//    3     6  9
//               