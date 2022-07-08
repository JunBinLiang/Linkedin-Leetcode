class Solution {
    public boolean judgeSquareSum(int c) {
        //2000000000
       
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
}