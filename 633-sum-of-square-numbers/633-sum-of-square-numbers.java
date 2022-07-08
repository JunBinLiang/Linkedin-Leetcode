class Solution {
    public boolean judgeSquareSum(int c) {
        long b = (long)(Math.sqrt(c) + 1);
        for(long i = 0; i * i <= c; i++) {
            long bb = c - i * i;
            while(b >= 0 && b * b > bb) b--;
            if(b * b == bb) {
                return true;
            }
        }
        return false;
    }
}
/*
class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Long> set = new HashSet<>();
        for(long i = 0; i * i <= c; i++) {
            set.add(i * i);
        }
        
        for(long i = 0; i * i <= c; i++) {
            //find if any number b * b == c - i * i
            long bb = c - i * i;
            if(set.contains(bb)) return true;
        }
        return false;
    }
}*/


//Sqrt(c)