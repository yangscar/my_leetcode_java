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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        while(p!=null){
            ListNode pre = dummy;
            while(pre.next!=null){
                if (pre.next.val <= p.val)
                    pre = pre.next;
                else break;
            }
            
            ListNode tmp = p.next;
            p.next = pre.next;
            pre.next = p;
            p = tmp;
            
        }
        
        return dummy.next;
    }
}
