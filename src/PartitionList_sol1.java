/**
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.



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
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);
        ListNode leftCur=leftHead, rightCur=rightHead;
        for(ListNode cur = head; cur!=null; cur = cur.next){
            // tail insert
            if (cur.val < x){
                leftCur.next = cur;
                leftCur = cur;
            }else{
                rightCur.next = cur;
                rightCur = cur;
            }
            
        }
        
        leftCur.next = rightHead.next;
        rightCur.next = null;
        return leftHead.next;
    }
}
