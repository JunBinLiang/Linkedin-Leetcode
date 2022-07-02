/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node pair[] = dfs(head);
        return pair[0];
    }
    
    public Node[] dfs(Node head) {
        
        Node cur = head;
        Node tail = null;
        while(cur != null) {
            if(cur.child != null) {
                Node pair[] = dfs(cur.child);
                cur.child = null;
                Node next = cur.next;
                cur.next = pair[0]; pair[0].prev = cur;
                pair[1].next = next; 
                if(next != null)next.prev = pair[1];
                tail = pair[1];
                cur = next;
            } else {
                tail = cur;
                cur = cur.next;
            }
        }
        return new Node[]{head, tail};
    }
}