class Solution {
    public boolean rotateString(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        s = s + s;
        return issub(s, t);
    }
    
    public boolean issub(String s, String t) {
        int pre[]=pre(t);
        int i = 0, pi = 0;
        while(i < s.length()){
            if(s.charAt(i) == t.charAt(pi)){
                i++;
                pi++;
            }else{
                if(pi == 0)i++;
                else pi = pre[pi - 1];
            }
            if(pi >= t.length()){
                return true;
            }
        }
        return false;
    }
    
    public int[] pre(String pattern){
        int pre[]=new int[pattern.length()];
        int l=0,r=1;
        while(r<pattern.length()){
            if(pattern.charAt(r)==pattern.charAt(l)){
                pre[r]=l+1;
                l++;
                r++;
            }else{
                if(l==0)r++;
                else{
                    l=pre[l-1];
                }
            }
        }
        return pre;
    }
}