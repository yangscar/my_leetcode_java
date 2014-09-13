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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null){
            boolean duplicated = false;
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                duplicated = true;
            }
            if (duplicated){
                cur = cur.next;
                continue;
            }
            prev.next = cur;
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur;
        return dummy.next;
    }
}
