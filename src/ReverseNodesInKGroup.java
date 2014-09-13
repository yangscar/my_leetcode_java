/**


Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = dummy.next;
        ListNode cur = prev;
        ListNode tmp, first = cur.next;
        while(prev.next!=null){
            for (int i = 1; i < k && end != null; ++i)
                end = end.next;
            if (end == null) break;
            cur = first.next;
            for (int i = 1; i< k; ++i){
                tmp = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                cur = tmp;
                first.next = tmp; // keep link completed
            }
            prev = first;
            end = cur;
            first = cur;
        }
        return dummy.next;
    }
}
