class AllOne {
    Map<String, Integer> f = new HashMap<>();
    Map<Integer, ListNode> g = new HashMap<>();
    ListNode head = new ListNode();
    ListNode tail = new ListNode();
    public AllOne() {
        head.next = tail;
        tail.pre = head;
    }
    
    public void inc(String key) {
        if(!f.containsKey(key)) {
            f.put(key, 1);
            if(g.containsKey(1)) {
                g.get(1).set.add(key);
            } else {
                ListNode node = new ListNode();
                g.put(1, node);
                node.set.add(key);
                add(head, node);
            }
            
        } else {
            int oldCnt = f.get(key);
            f.put(key, oldCnt + 1);
            if(g.containsKey(oldCnt + 1)) {
                g.get(oldCnt + 1).set.add(key);
                g.get(oldCnt).set.remove(key);
                if(g.get(oldCnt).set.size() == 0) {
                    delete(g.get(oldCnt));
                    g.remove(oldCnt);
                }
            } else {
                ListNode node = new ListNode();
                g.put(oldCnt + 1, node);
                add(g.get(oldCnt), node);
                g.get(oldCnt).set.remove(key);
                node.set.add(key);
                if(g.get(oldCnt).set.size() == 0) {
                    delete(g.get(oldCnt));
                    g.remove(oldCnt);
                }
            }
        }
    }
    
    public void dec(String key) {
        int oldCnt = f.get(key);
        if(oldCnt == 1) {
            f.remove(key);
            g.get(1).set.remove(key);
            if(g.get(1).set.size() == 0) {
                delete(g.get(1));
                g.remove(1);
            }
        } else {
            f.put(key, oldCnt - 1);
            if(g.containsKey(oldCnt - 1)) {
                g.get(oldCnt - 1).set.add(key);
                g.get(oldCnt).set.remove(key);
                if(g.get(oldCnt).set.size() == 0) {
                    delete(g.get(oldCnt));
                    g.remove(oldCnt);
                }
            } else {
                ListNode node = new ListNode();
                node.set.add(key);
                g.get(oldCnt).set.remove(key);
                ListNode pre = g.get(oldCnt).pre;
                g.put(oldCnt - 1,node);
                add(pre, node);
                if(g.get(oldCnt).set.size() == 0) {
                    delete(g.get(oldCnt));
                    g.remove(oldCnt);
                }
            }
        }
    }
    
    public String getMaxKey() {
        if(f.size() == 0) return "";
        ListNode node = tail.pre;
        String res = "";
        for(String s : node.set) {
            res = s;
            break;
        }
        return res;
    }
    
    public String getMinKey() {
        if(f.size() == 0) return "";
        ListNode node = head.next;
        String res = "";
        for(String s : node.set) {
            res = s;
            break;
        }
        return res;
    }
    
    public void add(ListNode pre, ListNode cur) {
        ListNode nxt = pre.next;
        pre.next = cur;
        cur.pre = pre;
        cur.next = nxt;
        nxt.pre = cur;
    }
    
    public void delete(ListNode node) {
        ListNode pre = node.pre;
        ListNode nxt = node.next;
        pre.next = nxt;
        nxt.pre = pre;
    }
    
    class ListNode {
        Set<String> set = new HashSet<>();
        ListNode next;
        ListNode pre;
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