//start : 7 : 05
//end : 7 : 10

class Solution {
    public double myPow(double x, int n) {
        return Pow(x, n);
    }
    
    public double Pow(double x, long n) {
        if(n == 0) {
            return 1;
        }
        
        if(n < 0) {
            return 1.0 / Pow(x, -n);
        }
        if(n == 1) {
            return x;
        }
        if(n % 2 == 1) {
            double y = Pow(x, n / 2);
            return x * y * y;
        } else {
            double y = Pow(x, n / 2);
            return y * y;
        }
    }
}