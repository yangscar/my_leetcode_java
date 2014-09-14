/**

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // cut at middle
        slow = reverse(slow);
        //merge them
        ListNode cur = head;
        while(cur.next != null){
            ListNode tmp = cur.next;
            cur.next = slow;
            slow = slow.next;
            cur.next.next = tmp;
            cur = tmp;
        }
        cur.next = slow;
        
    }
    
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        for (ListNode cur = head.next, next = cur.next; cur!=null;
                prev = cur, cur = next, next = (next == null)? next:next.next)
                cur.next = prev;
        head.next = null;
        return prev;
    }
}
