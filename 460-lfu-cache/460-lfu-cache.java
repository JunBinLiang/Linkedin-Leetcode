//based on frequency
//same frequency -> remove least recent

class LFUCache {
    Map<Integer, Node> f = new HashMap<>();
    Map<Integer, Bucket> g = new HashMap<>();
    int cap;
    int size = 0;
   
    Bucket head = new Bucket();
    Bucket tail = new Bucket();
    public LFUCache(int capacity) {
        cap = capacity;
        head.nxt = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(cap == 0) return -1;
        
        if(!f.containsKey(key)) {
            return -1;
        }
        
    
        Node node = f.get(key);
        int oldFre = node.fre;
        Bucket buc = g.get(oldFre);
        delete(node);
        buc.size--;
        
        
        node.fre++;
        if(!g.containsKey(node.fre)) {
            Bucket newbuc = new Bucket();
            newbuc.size++;
            addB(buc, newbuc);
            g.put(node.fre, newbuc);
            add(newbuc.tail, node);
        } else {
            Bucket newbuc = g.get(node.fre);
            newbuc.size++;
            add(newbuc.tail, node);
        }
        
        if(buc.size == 0) {
            g.remove(oldFre);
            delB(buc);
        }
        
    
        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        if(f.containsKey(key)) {
            Node node = f.get(key);
            int oldFre = node.fre;
            Bucket buc = g.get(node.fre);
            node.val = value;
            delete(node);
            buc.size--;
            node.fre++;
            if(!g.containsKey(node.fre)) {
                Bucket newbuc = new Bucket();
                newbuc.size++;
                addB(buc, newbuc);
                g.put(node.fre, newbuc);
                add(newbuc.tail, node);
            }else {
                Bucket newbuc = g.get(node.fre);
                newbuc.size++;
                add(newbuc.tail, node);
            }
            if(buc.size == 0) {
                g.remove(oldFre);
                delB(buc);
            }
        } else {
            
            
            if(size == cap) {
                size--;
                Bucket buc = head.nxt;
                Node delNode = buc.head.nxt;
                
            
                
                delete(delNode);
                f.remove(delNode.key);
                
                buc.size--;
                if(buc.size == 0) {
                    g.remove(delNode.fre);
                    delB(buc);
                }
            }
            
            Node node = new Node(value, key);
            node.fre = 1;
            f.put(key, node);
            if(!g.containsKey(1)) {
                Bucket newbuc = new Bucket();
                addB(head, newbuc);
                g.put(1, newbuc);
            } 
            g.get(1).size++;
            add(g.get(1).tail, node);
            size++;
        }
    }
    
    public void print(Bucket cur) {
        cur = cur.nxt;
        while(cur != tail) {
            Node nhead = cur.head;
            Node ntail = cur.tail;
            nhead = nhead.nxt;
            while(nhead != ntail) {
                System.out.print(nhead.val + " ");
                nhead = nhead.nxt;
            }
            System.out.println();
            cur = cur.nxt;
        }
        System.out.println();
    }
    
    class Bucket {
        int size = 0;
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        Bucket nxt;
        Bucket pre;
        public Bucket() {
            head.nxt = tail;
            tail.pre = head;
        }
    }
    
    public void delB(Bucket buc) { //delete bucket
        Bucket pre = buc.pre;
        Bucket nxt = buc.nxt;
        pre.nxt = nxt;
        nxt.pre = pre;
    }
    
    public void addB(Bucket pre, Bucket buc) { //previoud bucket
        Bucket nxt = pre.nxt;
        pre.nxt = buc;
        buc.pre = pre;
        buc.nxt = nxt;
        nxt.pre = buc;
    }
    
    
    class Node{
        Node pre;
        Node nxt;
        int val;
        int key;
        int fre = 0;
        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
    
    public void delete(Node node) {
        Node pre = node.pre;
        Node nxt = node.nxt;
        pre.nxt = nxt;
        nxt.pre = pre;
    }
    
    public void add(Node tail, Node node) {
        Node pre = tail.pre;
        pre.nxt = node;
        node.pre = pre;
        node.nxt = tail;
        tail.pre = node;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */