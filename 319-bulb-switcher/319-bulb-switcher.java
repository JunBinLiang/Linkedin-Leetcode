class Solution {
    public int bulbSwitch(int n) {
        /*for(int i = 1; i * i <= n; i++) {
            res++;
        }*/
        return (int)(Math.sqrt(n));
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

//1. touch odd number of times
//2. when it will get touched : yinshu touched
//3. [1 - n]  how many numbers yinshu odd numbers
//4. perfect square yinshu odd numbers