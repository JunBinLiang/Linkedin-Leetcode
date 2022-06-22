class AllOne {
    List<Set<String>> list = new ArrayList<>();
    Map<String, Integer> f = new HashMap<>();
    int cnt = 0;
    
    int mnIdx = -1, mxIdx = -1;
    public AllOne() {
        list.add(new HashSet<>());
    }
    
    public void inc(String key) {
        if(!f.containsKey(key)) {
            cnt++;
            if(list.size() == 1) list.add(new HashSet<>());
            f.put(key, 1);
            list.get(1).add(key);
            if(mnIdx == -1 && mxIdx == -1) {
                mnIdx = 1;
                mxIdx = 1;
            } else {
                mxIdx = Math.max(mxIdx, 1);
                mnIdx = Math.min(mnIdx, 1);
            }
            
            
        } else {
            int oldCnt = f.get(key);
            if(list.size() == oldCnt + 1) list.add(new HashSet<>());
            f.put(key, oldCnt + 1);
            
            list.get(oldCnt).remove(key);
            list.get(oldCnt + 1).add(key);
            
            mxIdx = Math.max(mxIdx, oldCnt + 1);
            if(mnIdx == oldCnt && list.get(oldCnt).size() == 0) {
                mnIdx++;
            }
            
        }
        //System.out.println("inc " + f + " " + mnIdx + " " + mxIdx);
    }
    
    public void dec(String key) {
        int oldCnt = f.get(key);
        list.get(oldCnt).remove(key);
        if(oldCnt == 1) {
            cnt--;
            f.remove(key);
            if(cnt == 0) {
                mnIdx = -1;
                mxIdx = -1;
            } else {
                for(int i = 1; i < list.size(); i++) {
                    if(list.get(i).size() > 0) {
                        mnIdx = i;
                        break;
                    }
                }
            }
            
            
        } else {
            f.put(key, oldCnt - 1);
            list.get(oldCnt - 1).add(key);
            if(mxIdx == oldCnt && list.get(oldCnt).size() == 0) {
                mxIdx--;
            }
            mnIdx = Math.min(mnIdx, oldCnt - 1);
        }
        
    }
    
    public String getMaxKey() {
        if(mxIdx == -1) return "";
        String res = "";
        Set<String> set = list.get(mxIdx); 
        for(String s : set) {
            res = s;
            break;
        }
       // System.out.println("max  " + f);
        return res;
    }
    
    public String getMinKey() {
        if(mnIdx == -1) return "";
        String res = "";
        Set<String> set = list.get(mnIdx); 
        for(String s : set) {
            res = s;
            break;
        }
        //System.out.println("min  " + f+"  " + mnIdx);
        return res;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

//[string, counter]

/*
["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
*/