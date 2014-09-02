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
        if (head ==null) return head;
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr != null){
            if (curr.val!=prev.val){
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = curr;
        return head;
    }
}
