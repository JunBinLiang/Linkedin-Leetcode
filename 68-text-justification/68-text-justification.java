class Solution {
    public List<String> fullJustify(String[] a, int width) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            int j = i;
            int sum = 0, cnt = 0;
            List<String> list = new ArrayList<>();
            while(j < a.length && sum + a[j].length() + (cnt + 1 - 1) <= width) {
                cnt++;
                sum += a[j].length();
                list.add(a[j]);
                j++;
            }
            
            int space = width - sum;
            int chunk = list.size() - 1;
            StringBuilder str = new StringBuilder();
            
            if(j >= a.length) { //last line
                for(String s : list) {
                    str.append(s);
                    if(str.length() < width)str.append(" ");
                }
                str.append(space(width - str.length()));
                res.add(str.toString());
                i = j - 1;
                break;
            }
            
            if(chunk == 0) {
                str.append(list.get(0));
                str.append(space(width - str.length()));
            } else {
                int cnt1 = space / chunk;
                int mod = space % chunk;
                for(int x = 0; x < list.size(); x++) {
                    str.append(list.get(x));
                    if(x != list.size() - 1) {
                        str.append(space(cnt1));
                        if(x < mod) {
                            str.append(" ");
                        }
                    }
                }
            }
            res.add(str.toString());
            i = j - 1;
        }
        return res;
    }
    
    public String space(int t) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < t; i++) str.append(" ");
        return str.toString();
    }
}

//15 space   
// 4 chunk
//4 4 4 3 