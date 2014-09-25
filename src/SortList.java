/**
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null; //cut off
        return mergeTwoLists(sortList(head),sortList(slow));
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        for (ListNode p = dummy; l1!=null || l2!=null;p=p.next){
            int val1 = l1==null? Integer.MAX_VALUE : l1.val;
            int val2 = l2==null? Integer.MAX_VALUE : l2.val;
            if (val1 <= val2){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
