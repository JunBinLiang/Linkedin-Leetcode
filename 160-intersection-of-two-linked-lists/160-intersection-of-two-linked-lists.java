/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cnt1 = 0, cnt2 = 0;
        ListNode cur1 = headA, cur2 = headB;
        while(cur1 != null) {
            cnt1++;
            cur1 = cur1.next;
        }
        
        while(cur2 != null) {
            cnt2++;
            cur2 = cur2.next;
        }
        
        cur1 = headA;
        cur2 = headB;
        int dif = Math.abs(cnt1 - cnt2);
        if(cnt1 > cnt2) {
            for(int i = 0; i < dif; i++) {
                cur1 = cur1.next;
            }
        } else {
            for(int i = 0; i < dif; i++) {
                cur2 = cur2.next;
            }
        }
        
        while(cur1 != null) {
            if(cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
        
        
    }
}