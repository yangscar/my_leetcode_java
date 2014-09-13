/**

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) return head;
        ListNode dummy = new ListNode(-1);
        int len = 1;
        ListNode p = head;
        while(p.next!=null){
            len++;
            p=p.next;
        }
        n = len - n % len;
        p.next = head; // to circle;
        for (int step = 0; step < n; ++step)
            p = p.next;
        head = p.next;
        p.next = null;
        return head;
    }
}
