class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int res[] = new int[n];
        
        Stack<int[]> sta = new Stack<>(); //[id, logIdx]
        
        for(int i = 0; i < logs.size(); i++) {
            String s = logs.get(i);
            String a[] = s.split(":");
            int id = Integer.parseInt(a[0]), t = Integer.parseInt(a[2]);
            
            if(a[1].equals("start")) {
                sta.push(new int[]{id, t, 0});
            } else {
                int pair[] = sta.pop();
                int add = t - pair[1] + 1;
                
                
               // System.out.println("pre  :" + add);
                add -= pair[2];
               // System.out.println(Arrays.toString(pair) + " " + add);
                
                res[pair[0]] += add;
                if(sta.size() > 0) {
                    sta.peek()[2] += (add + pair[2]);
                }
            }
        }
        return res;
    }
}

//

