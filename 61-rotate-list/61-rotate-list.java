/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        
        ListNode cur = head;
        ListNode tail = null;
        int cnt = 0;
        while(cur != null) {
            cnt++;
            tail = cur;
            cur = cur.next;
        }
        
        k %= cnt;
        if(k == 0) {
            return head;
        }
        
        ListNode nxt = null;
        cur = head;
        for(int i = 0; i < cnt - k - 1; i++) {
            cur = cur.next;
            
        }
        nxt = cur.next;
        
        
        //re-structure
        cur.next = null;
        tail.next = head;
        return nxt;
    }
}