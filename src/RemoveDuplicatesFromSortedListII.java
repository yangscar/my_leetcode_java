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
        //ListNode dummy = new ListNode(-1);
        ListNode p = head.next;
        if (head.val == p.val){
            while (p!=null && head.val == p.val){
                p = p.next;
            }
            return deleteDuplicates(p);
        }else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
        
    }
}
