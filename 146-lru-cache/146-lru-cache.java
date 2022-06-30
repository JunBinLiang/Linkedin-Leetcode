class LRUCache {
    Node head, tail;
    Map<Integer, Node> f = new HashMap<>();
    int cap;
    int size = 0;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.nxt = tail;
        tail.pre = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if(f.containsKey(key)) {
            Node node = f.get(key);
            delete(node);
            add(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(f.containsKey(key)) {
            Node node = f.get(key);
            node.val = value;
            delete(node);
            add(node);
        } else {
            size++;
            Node node = new Node(value, key);
            add(node);
            f.put(key, node);
            if(size > cap) {
                size--;
                f.remove(head.nxt.key);
                delete(head.nxt);
                
            }
        }
    }
    
    class Node{
        Node pre;
        Node nxt;
        int val;
        int key;
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
    
    public void add(Node node) {
        Node pre = tail.pre;
        pre.nxt = node;
        node.pre = pre;
        node.nxt = tail;
        tail.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


